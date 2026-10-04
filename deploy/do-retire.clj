#!/usr/bin/env bb
;; Retire the old DigitalOcean droplet that served zhealth.nz under Biff.
;; Needs DIGITALOCEAN_TOKEN (read/write) in the environment.
;;
;;   bb do-retire.clj                     list droplets; mark the one on the old IP
;;   bb do-retire.clj --snapshot ID       snapshot it first (optional, billed monthly)
;;   bb do-retire.clj --delete ID         permanently delete it

(require '[babashka.http-client :as http]
         '[cheshire.core :as json])

(def old-ip "170.64.172.87")
(def api "https://api.digitalocean.com/v2")

(def token (or (System/getenv "DIGITALOCEAN_TOKEN")
               (do (println "DIGITALOCEAN_TOKEN is not set") (System/exit 2))))

(defn call [method path & [body]]
  (let [resp (http/request {:method method :uri (str api path) :throw false
                            :headers {"authorization" (str "Bearer " token)
                                      "content-type" "application/json"}
                            :body (some-> body json/generate-string)})]
    (when (>= (:status resp) 300)
      (println "DigitalOcean API" (:status resp) (:body resp))
      (System/exit 1))
    (some-> (:body resp) not-empty (json/parse-string true))))

(defn public-ip [d]
  (->> d :networks :v4 (filter #(= "public" (:type %))) first :ip_address))

(defn droplet [id] (:droplet (call :get (str "/droplets/" id))))

(defn confirm! [prompt expected]
  (print prompt) (flush)
  (when-not (= expected (read-line))
    (println "Aborted.") (System/exit 1)))

(let [[cmd id] *command-line-args*]
  (case cmd
    nil
    (doseq [d (:droplets (call :get "/droplets?per_page=200"))]
      (println (format "%s%-12s %-24s %-16s %-6s %s"
                       (if (= old-ip (public-ip d)) "* " "  ")
                       (:id d) (:name d) (public-ip d) (-> d :region :slug) (:status d))))

    "--snapshot"
    (let [d (droplet id)
          name (str (:name d) "-final-" (subs (str (java.time.LocalDate/now)) 0 10))]
      (call :post (str "/droplets/" id "/actions") {:type "snapshot" :name name})
      (println "Snapshot requested:" name "(check progress in the DO console)"))

    "--delete"
    (let [d (droplet id)]
      (println "About to permanently delete" (:id d) (:name d) (public-ip d))
      (when-not (= old-ip (public-ip d))
        (println "Warning: this droplet is not on the old zhealth IP" old-ip))
      (confirm! "Type the droplet name to confirm: " (:name d))
      (call :delete (str "/droplets/" id))
      (println "Deleted" (:name d)))

    (do (println "Usage: bb do-retire.clj [--snapshot ID | --delete ID]")
        (System/exit 2))))
