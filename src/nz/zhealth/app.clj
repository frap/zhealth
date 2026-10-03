(ns nz.zhealth.app
  (:require
   [hyper.core :as h]
   [nz.zhealth.pages.home :as home]
   [nz.zhealth.pages.why :as why]
   [nz.zhealth.pages.classes :as classes]
   [nz.zhealth.pages.timetable :as timetable]
   [nz.zhealth.pages.about :as about]))

(def head
  [[:meta {:name "description"
           :content "Z Health offers Yoga, Pilates, and Wellness classes in the heart of Kāpiti."}]

   [:link {:rel "stylesheet"
           :href "/css/main.css"}]

   [:link {:rel "icon"
           :href "/favicon.ico"}]

   [:meta {:name "theme-color"
           :content "#0d9488"}]])

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
     :get #'about/page}]])

(def handler
  (h/create-handler
   #'routes
   :static-resources "public"
   :head #'head))

(defonce server
  (h/start! handler {:port 3000}))

