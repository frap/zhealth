(ns view.layout
  (:require
   [config :refer [hotreload?]]
   [cheshire.core :as json]
   [hiccup2.core :as h]
   [utils.session :as s]
   [utils.response :as r]
   [utils.htmc :as hc]
   [view.style :as sty]
   [view.core :as c]))


(def squint-cdn-path "https://cdn.jsdelivr.net/npm/squint-cljs@0.8.114")

(defn paginator [req current-page pages base-url]
  (let* [q (:query-params req)
         next (when (not= current-page pages)
                (str base-url "?" (r/query-params->url (merge q {"page" (+ current-page 1)}))))
         previous (when (not= current-page 1)
                    (str base-url "?" (r/query-params->url (merge q {"page" (- current-page 1)}))))]
    [:div.flex.justify-center.mb-4
     [:div.flex.space-x-2
      [:a {:class "px-4 py-2 rounded bg-cyan-500 text-white hover:bg-cyan-600 disabled:opacity-50"
           :href (or previous "#")
           :disabled (nil? previous)} "Previous"]
      [:span.text-gray-600.text-sm.pt-2 (str current-page " / " pages)]
      [:a {:class "px-4 py-2 rounded bg-cyan-500 text-white hover:bg-cyan-600 disabled:opacity-50"
           :href (or next "#")
           :disabled (nil? next)} "Next"]]]))

(defn autocomplete-input [& {:keys [label name value list required]}]
  [:div.mb-4
   [:label.block.text-sm.font-medium.text-gray-700 label]
   [:input {:type "text"
            :list (str name "list")
            :name name
            :value value
            :required required
            :autocomplete "off"
            :class "mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-cyan-500 focus:ring-cyan-500"}]
   [:datalist {:id (str name "list")}
    (map (fn [e] [:option {:value e}]) list)]])

(defn form-input [& {:keys [id label type name value required] :as opts}]
  (cond
    (= type "textarea")
    [:div.mb-4
     [:label.block.text-sm.font-medium.text-gray-700 label]
     [:textarea {:name name
                 :required required
                 :class "mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-cyan-500 focus:ring-cyan-500"} value]]

    (= type "autocomplete")
    (autocomplete-input opts)

    (= type "base64-upload")
    [:div.mb-4
     [:label.block.text-sm.font-medium.text-gray-700 label]
     (c/cljs-module "base64-upload")
     [:input {:type "file"
              :required required
              :onchange (str "base64_upload(\"" id "\", this)")
              :class "mt-1 block w-full text-sm text-gray-500 file:mr-4 file:py-2 file:px-4 file:rounded-md file:border-0 file:text-sm file:font-semibold file:bg-cyan-50 file:text-cyan-700 hover:file:bg-cyan-100"}]
     [:input {:type "hidden" :name name :id (or id label)}]]

    :else
    [:div.mb-4
     [:label.block.text-sm.font-medium.text-gray-700 label]
     [:input {:type type
              :value value
              :name name
              :required required
              :class "mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-cyan-500 focus:ring-cyan-500"}]]))


;;
;; Extend importmap. This enables you to load other libraries in your
;; js files. The key is the libraries name in your app if you require it
;;
(defn global-importmap []
  [:script {:type "importmap"}
   (h/raw
    (json/encode
     {:imports
      {"squint-cljs/core.js" (str squint-cdn-path "/src/squint/core.js")
       "squint-cljs/string.js" (str squint-cdn-path "/src/squint/string.js")
       "squint-cljs/src/squint/string.js" (str squint-cdn-path "/src/squint/string.js")
       "squint-cljs/src/squint/set.js" (str squint-cdn-path "/src/squint/set.js")
       "squint-cljs/src/squint/html.js" (str squint-cdn-path "/src/squint/html.js")}}))])

(defn navbar [req]
  (let [user (s/current-user req)]
    [:nav {:class "bg-zinc-50 shadow-md sticky top-0 z-50"}
     [:div {:class "max-w-7xl mx-auto px-4 sm:px-6 lg:px-8"}
      [:div {:class "flex justify-between h-16 items-center"}
       ;; Logo
       [:a {:href "/" :class "text-xl font-bold text-cyan-600"} "Z Health Yoga·Pilates"]
        ;; Desktop links
        [:div {:class "hidden sm:flex space-x-4"}
         (if user
           [:div
            [:a {:href "/profile" :class "text-gray-700 hover:text-cyan-500"} "Profile"]
            [:a {:href "/logout" :class "text-gray-700 hover:text-cyan-500"} "Logout"]]
           [:div
            [:a {:href "/login" :class "text-gray-700 hover:text-cyan-500"} "Login"]
            [:a {:href "/register" :class "text-gray-700 hover:text-cyan-500"} "Register"]
            [:a {:href "/kitchensink" :class "text-gray-700 hover:text-cyan-500"} "Classes"]])]

        ;; Burger button
       [:button {:class "sm:hidden text-gray-700 hover:text-cyan-600 focus:outline-none"
                 ;; :onClick #(set-open (not open))
                 }
        [:svg {:class "h-6 w-6" :xmlns "http://www.w3.org/2000/svg" :fill "none" :viewBox "0 0 24 24" :stroke "currentColor"}
         [:path {:strokeLinecap "round" :strokeLinejoin "round" :strokeWidth "2"
                 :d                     ;;( if open
                 "M6 18L18 6M6 6l12 12" ; X icon
                 ;;"M4 6h16M4 12h16M4 18h16"
                ;; )
                 }]]]
       ]]]))

(defn navbar2 [req]
  (let [user (s/current-user req)]
    [:nav {:class "bg-zinc-50 shadow-md sticky top-0 z-50"}
     [:div {:class "max-w-7xl mx-auto px-4 sm:px-6 lg:px-8"}
      [:div {:class "flex justify-between h-16 items-center"}

       ;; Logo
       [:a {:href "/" :class "text-xl font-bold text-cyan-600"} "Z Health Yoga·Pilates"]

       ;; Mobile burger (input + label)
       [:div {:class "sm:hidden"}
        [:input {:id "menu-toggle" :type "checkbox" :class "hidden peer"}]
        [:label {:for "menu-toggle"
                 :class "cursor-pointer text-gray-700 hover:text-cyan-600"}
         [:svg {:class "h-6 w-6" :fill "none" :viewBox "0 0 24 24" :stroke "currentColor"}
          [:path {:strokeLinecap "round" :strokeLinejoin "round" :strokeWidth "2"
                  :d "M4 6h16M4 12h16M4 18h16"}]]]]

       ;; Desktop links
       [:div {:class "hidden sm:flex space-x-6"}
        [:div {:class "px-2 pt-2 pb-3 space-y-1"}
         (if user
           [:div
            [:a {:href "/profile" :class "text-gray-700 hover:text-cyan-500"} "Profile"]
            [:a {:href "/logout" :class "text-gray-700 hover:text-cyan-500"} "Logout"]]
           [:div
            [:a {:href "/login" :class "px-2 text-gray-700 hover:text-cyan-500"} "Login"]
            [:a {:href "/register" :class "px-2 text-gray-700 hover:text-cyan-500"} "Register"]
            [:a {:href "/kitchensink" :class "px-2 text-gray-700 hover:text-cyan-500"} "Classes"]])]
        ]]]

     ;; Mobile menu (shown when input is checked)
     [:div {:class "sm:hidden peer-checked:max-h-60 max-h-0 overflow-hidden transition-all duration-300"}
      [:div {:class "px-2 pt-2 pb-3 space-y-1"}
       (if user
         [:div
          [:a {:href "/profile" :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:bg-cyan-100"} "Profile"]
          [:a {:href "/logout" :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:bg-cyan-100"} "Logout"]]
         [:div
          [:a {:href "/login" :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:bg-cyan-100"} "Login"]
          [:a {:href "/register" :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:bg-cyan-100"} "Register"]
          [:a {:href "/kitchensink" :class "block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:bg-cyan-100"} "Classes"]])
       ]]
     ]))

(defn alert [req]
  (let* [msg (get-in req [:flash :message])
         severity (:severity msg)
         message (:message msg)
         class (case severity
                 "success" "bg-green-100 text-green-800"
                 "warning" "bg-yellow-100 text-yellow-800"
                 "danger"  "bg-red-100 text-red-800"
                 "info"    "bg-blue-100 text-blue-800"
                 "bg-zinc-50 text-slate-800")]
    [:div {:class (str " rounded p-4 mb-4 " class) :role "alert"}
     message]))


(defn layout [req & body]
  (str
   (h/html
    [:html
     [:head
      [:meta {:charset "utf-8"}]
      [:meta {:name "viewport"
              :content "width=device-width, initial-scale=1"}]
      [:link {:rel "manifest" :href "/manifest.json"}]
      (global-importmap)
      (c/cljs-module "register-sw")
      (when hotreload?
        (c/cljs-module "hotreload"))
      [:script {:src "https://cdn.tailwindcss.com"}]
      [:style (h/raw sty/*style*)]]
     [:body.bg-zinc-50.text-slate-900.min-h-screen.flex.flex-col
      (hc/htmc)
      (navbar2 req)
      [:div.flex-1.container.mx-auto.p-4
       (alert req)
       body]
      ]])))

  (defn modal [& {:keys [id title content actions]}]
    [:div.fixed.inset-0.bg-black.bg-opacity-50.flex.items-center.justify-center.z-50 {:id id}
     [:div.bg-zinc-50.rounded-lg.shadow-lg.max-w-md.w-full
      [:div.flex.justify-between.items-center.border-b.p-4
       [:h5.text-lg.font-medium title]
       [:button.text-gray-400.hover:text-gray-600 {:type "button" :onclick (str "document.getElementById('" id "').classList.add('hidden')")} "✕"]]
      [:div.p-4 content]
      [:div.flex.justify-end.space-x-2.p-4.border-t actions]]])
