(ns view.kitchensink
  (:require
   [view.core :as c]
   [view.layout :as l]))

(def class-schedule
  [:section.bg-white.py-16
 [:div.max-w-4xl.mx-auto.px-4.sm:px-6.lg:px-8
  [:h2.text-3xl.font-bold.text-gray-900.mb-6 "Weekly Class Schedule"]
  [:table.w-full.table-auto.border-collapse
   [:thead
    [:tr.bg-cyan-100
     [:th.px-4.py-2.text-left.text-gray-700 "Day"]
     [:th.px-4.py-2.text-left.text-gray-700 "Time"]
     [:th.px-4.py-2.text-left.text-gray-700 "Class"]
     [:th.px-4.py-2.text-left.text-gray-700 "Location"]]]
   [:tbody
    (for [session [["Monday" "6:00-7:00 PM" "Vinyasa Flow" "On-line"]
                   ["Tuesday" "10:00-11:00 AM" "Yogilates" "Paraparumu Community Hall"]
                   ["Thursday" "10:00-11:00 AM" "Yogilates" "Paraparumu Community Hall"]
                   ["Thursday" "5:30-6:30 PM" "Restorative Yoga" "On-line"]
                   ["Saturday" "9:00-9:45 AM" "Yin Yoga" "Raumati Hall"]
                   ["Saturday" "9:00-9:45 AM" "Pilates" "Raumati Hall"]
                   ]]
      [:tr.border-b
       (for [item session]
         [:td.px-4.py-2.text-gray-700 item])])]]]])

;;
;; Here is the example page of all the included components
;; for your webapp. Like FileDropAreas, Autocompletes or Modals
;;
(defn index [req]
  (l/layout
   req
   [:div {:class "max-w-6xl mx-auto p-6 space-y-8"}

    ;; Title Section
    [:div
     [:h1 {:class "text-3xl font-bold text-cyan-700"} "Classes"]]

    class-schedule

    ;; Preact Components Section
    [:div {:class "grid grid-cols-1 md:grid-cols-2 gap-8"}

     ;; Left Column
     [:div
      [:h3 {:class "text-xl font-semibold text-gray-800 mb-2"} "Preact Components"]
      [:div#cljs {:class "mb-4 border rounded-md p-4 bg-gray-50"}]]

     ;; Right Column
     [:div
      [:h3 {:class "text-xl font-semibold text-gray-800 mb-2"} "Web Component"]
      [:div {:class "border rounded-md p-4 bg-gray-50"}
       [:x-greeting {:name "test"}]]]]

    ;; Include cljs modules
    (c/cljs-module "counter")
    (c/cljs-module "custom-element")]))
