(ns nz.zhealth.app
  (:require
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
             :body "pong"})}]])

(def handler
  (h/create-handler
   #'routes
   :static-resources "public"
   :head #'head/head
   :not-found #'layout/not-found))

(defn -main [& _]
  (let [port (parse-long (or (System/getenv "PORT") "3000"))]
    (h/start! handler {:port port})))
