(ns view.login
  (:require
   [utils.response :as r]
   [view.core :as c]
   [view.layout :as l]
   [database.user :as user]))

(defn logout [req]
  (assoc (r/redirect "/")
         :session nil))

(defn login [req]
  (let [email (get-in req [:params "email"])]
    (if (user/correct-password?
         email
         (get-in req [:params "password"]))
      (assoc (r/redirect "/")
             :session {:user-id (:users/id (user/by-email email))})
      (r/flash-msg (r/redirect "/login") "danger" "Wrong username or password"))))

;;
;; Login form. Adjust to your needs
;;
(defn index [req]
  (l/layout
   req
   [:div {:class "max-w-md mx-auto mt-10 p-6 bg-white shadow-md rounded-md"}
    [:h1 {:class "text-2xl font-bold text-center text-cyan-700 mb-6"} "Login"]
    [:form {:method "post" :action "/login" :class "space-y-4"}
     (c/csrf-token)

     [:div
      [:label {:for "email" :class "block text-sm font-medium text-gray-700"} "E-Mail"]
      [:input {:type "email"
               :name "email"
               :id "email"
               :placeholder "Enter your email address"
               :class "mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-cyan-500 focus:border-cyan-500"}]]

     [:div
      [:label {:for "password" :class "block text-sm font-medium text-gray-700"} "Password"]
      [:input {:type "password"
               :name "password"
               :id "password"
               :class "mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:ring-cyan-500 focus:border-cyan-500"}]]

     [:div
      [:input {:type "submit"
               :value "Login"
               :class "w-full bg-cyan-600 hover:bg-cyan-700 text-white font-medium py-2 px-4 rounded-md transition"}]]]])
  )
