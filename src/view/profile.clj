(ns view.profile
  (:require
   [view.layout :as l]))

(defn index [req]
  (l/layout
   req
   [:div {:class "max-w-md mx-auto mt-10 p-6 bg-white shadow-md rounded-md"}
    [:h1 {:class "text-2xl font-bold text-center text-indigo-700 mb-6"} "Profile"]]
   ))
