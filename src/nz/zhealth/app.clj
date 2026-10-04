(ns nz.zhealth.app
  (:require
   [clojure.string :as str]
   [hyper.core :as h]
   [nz.zhealth.head :as head]
   [nz.zhealth.layout :as layout]
   [nz.zhealth.pages.home :as home]
   [nz.zhealth.pages.why :as why]
   [nz.zhealth.pages.classes :as classes]
   [nz.zhealth.pages.timetable :as timetable]
   [nz.zhealth.pages.about :as about])
  (:gen-class))

(def routes
  [["/"
    {:name :home
     :title "Z Health"
     :get #'home/page}]

   ["/why"
    {:name :why
     :title "Why Z Health?"
     :get #'why/page}]

   ["/classes"
    {:name :classes
     :title "Classes | Z Health"
     :get #'classes/page}]

   ["/timetable"
    {:name :timetable
     :title "Timetable | Z Health"
     :get #'timetable/page}]

   ["/about"
    {:name :about
     :title "About | Z Health"
     :get #'about/page}]

   ["/ping"
    {:name :ping
     :hyper/disabled? true
     :get (fn [_]
            {:status 200
             :headers {"content-type" "text/plain; charset=utf-8"}
             :body "pong"})}]

   ;; Healthcheck required by ONCE
   ["/up"
    {:name :up
     :hyper/disabled? true
     :get (fn [_]
            {:status 200
             :headers {"content-type" "text/plain; charset=utf-8"}
             :body "ok"})}]])

(def canonical-host "zhealth.nz")

;; ONCE serves www.zhealth.nz as its own app from the same image; send it to
;; the apex. Wraps outside hyper's static layer so assets redirect too.
(defn wrap-www-redirect [handler]
  (fn [req]
    (let [host (some-> (get-in req [:headers "host"]) (str/replace #":\d+$" ""))]
      (if (= host (str "www." canonical-host))
        {:status 301
         :headers {"location" (str "https://" canonical-host (:uri req)
                                   (when-let [q (:query-string req)] (str "?" q)))}}
        (handler req)))))

(def handler
  (let [h (h/create-handler
           #'routes
           :static-resources "public"
           :head #'head/head
           :not-found #'layout/not-found)]
    ;; start! reads hyper's app state from the handler's metadata
    (with-meta (wrap-www-redirect h) (meta h))))

(defn -main [& _]
  (let [port (parse-long (or (System/getenv "PORT") "3000"))]
    (h/start! handler {:port port})))
