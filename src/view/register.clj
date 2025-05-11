(ns view.register
  (:require
   [database.user :as user]
   [view.layout :as l]
   [view.core :as c]
   [utils.response :as r]))

(defn save-user [req]
  (user/insert
   {:email (get-in req [:params "email"])
    :password (get-in req [:params "password1"])})
  (r/redirect "/"))

(defn save [req]
  (if (= (get-in req [:params "password1"])
         (get-in req [:params "password2"]))
    (save-user req)
    (r/flash-msg
     (r/redirect "/register")
     "danger" "Password don't match")))

;;
;; Register form. Adjust to your needs
;;
(defn index [req]
  (l/layout
   req
   [:div {:class "max-w-md mx-auto p-6"}
    [:h1 {:class "text-2xl font-bold mb-6"} "Register"]
    [:form {:method "post" :action "/register" :class "space-y-4"}
     (c/csrf-token)

     [:div
      [:label {:for "email" :class "block text-sm font-medium text-gray-700"} "E-Mail"]
      [:input {:type "email"
               :name "email"
               :id "email"
               :placeholder "E-Mail"
               :class "mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500"}]]

     [:div
      [:label {:for "password1" :class "block text-sm font-medium text-gray-700"} "Password"]
      [:input {:type "password"
               :name "password1"
               :id "password1"
               :class "mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500"}]]

     [:div
      [:label {:for "password2" :class "block text-sm font-medium text-gray-700"} "Password again"]
      [:input {:type "password"
               :name "password2"
               :id "password2"
               :class "mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500"}]]

     [:div
      [:input {:type "submit"
               :value "Register"
               :class "w-full bg-indigo-600 text-white font-medium py-2 px-4 rounded hover:bg-indigo-700 cursor-pointer"}]]]])
  )
