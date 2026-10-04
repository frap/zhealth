#!/usr/bin/env bb
;; Check the R2 key in COLORS_PAR_R2_* can list the state bucket from colors.yml.
;; Signs a ListObjectsV2 request with SigV4 and deliberately sends no session token.
;;
;;   cd deploy && bb r2-check.clj

(require '[babashka.http-client :as http]
         '[clj-yaml.core :as yaml]
         '[clojure.string :as str])

(import '[java.security MessageDigest]
        '[javax.crypto Mac]
        '[javax.crypto.spec SecretKeySpec]
        '[java.time ZonedDateTime ZoneOffset]
        '[java.time.format DateTimeFormatter])

(defn hex [^bytes bs] (apply str (map #(format "%02x" (bit-and % 0xff)) bs)))
(defn sha256 [^String s] (hex (.digest (MessageDigest/getInstance "SHA-256") (.getBytes s "UTF-8"))))
(defn hmac [^bytes k ^String s]
  (.doFinal (doto (Mac/getInstance "HmacSHA256") (.init (SecretKeySpec. k "HmacSHA256")))
            (.getBytes s "UTF-8")))

(let [{:keys [r2-bucket r2-endpoint]} (yaml/parse-string (slurp "colors.yml"))
      access  (System/getenv "COLORS_PAR_R2_ACCESS_KEY_ID")
      secret  (System/getenv "COLORS_PAR_R2_SECRET_ACCESS_KEY")
      _       (when-not (and access secret)
                (println "COLORS_PAR_R2_ACCESS_KEY_ID / COLORS_PAR_R2_SECRET_ACCESS_KEY not set")
                (System/exit 2))
      host    (str/replace r2-endpoint #"^https://" "")
      now     (ZonedDateTime/now ZoneOffset/UTC)
      amzdate (.format now (DateTimeFormatter/ofPattern "yyyyMMdd'T'HHmmss'Z'"))
      day     (subs amzdate 0 8)
      payload (sha256 "")
      path    (str "/" r2-bucket)
      query   "list-type=2&max-keys=1"
      signed  "host;x-amz-content-sha256;x-amz-date"
      canon   (str/join "\n" ["GET" path query
                              (str "host:" host)
                              (str "x-amz-content-sha256:" payload)
                              (str "x-amz-date:" amzdate)
                              "" signed payload])
      scope   (str day "/auto/s3/aws4_request")
      to-sign (str/join "\n" ["AWS4-HMAC-SHA256" amzdate scope (sha256 canon)])
      k       (reduce hmac (.getBytes (str "AWS4" secret) "UTF-8") [day "auto" "s3" "aws4_request"])
      sig     (hex (hmac k to-sign))
      resp    (http/get (str r2-endpoint path "?" query)
                        {:throw false
                         :headers {"x-amz-date" amzdate
                                   "x-amz-content-sha256" payload
                                   "authorization" (str "AWS4-HMAC-SHA256 Credential=" access "/" scope
                                                        ", SignedHeaders=" signed ", Signature=" sig)}})]
  (println "bucket:" r2-bucket)
  (println "status:" (:status resp))
  (if (= 200 (:status resp))
    (println "OK: key can list the bucket"
             (str "(" (or (second (re-find #"<KeyCount>(\d+)</KeyCount>" (:body resp))) "?") " object shown)"))
    (do (println "FAILED:" (or (second (re-find #"<Code>([^<]+)</Code>" (str (:body resp)))) (:body resp)))
        (System/exit 1))))
