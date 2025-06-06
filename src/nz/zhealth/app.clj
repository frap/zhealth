(ns nz.zhealth.app
  (:require [com.biffweb :as biff :refer [q]]
            [nz.zhealth.middleware :as mid]
            [nz.zhealth.ui :as ui]
            [nz.zhealth.settings :as settings]
            [xtdb.api :as xt]
            ))

(defn app [{:keys [session biff/db] :as ctx}]
  (let [{:user/keys [email]} (xt/entity db (:uid session))]
    (ui/page
     {}
     [:div "Signed in as " email ". "
      (biff/form
       {:action "/auth/signout"
        :class "inline"}
       [:button.text-blue-500.hover:text-blue-800 {:type "submit"}
        "Sign out"])
      "."]
     [:.h-6]
     [:div "ZHealth start."])
    ))

(def about-page
  (ui/page
   {:base/title (str "About " settings/app-name)}
   [:p "This app was made with "
    [:a.link {:href "https://biffweb.com"} "Biff"] "."]))


;; (def module
;;   {:static {"/about/" about-page}
;;    :routes ["/app" {:middleware [mid/wrap-signed-in]}
;;             ["" {:get app}]]
;;    })
