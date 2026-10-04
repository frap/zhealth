(ns nz.zhealth.layout
  (:require [hyper.core :as h]
            [nz.zhealth.components :as c]))

(def nav-items
  [[:why "Why Zhealth?"]
   [:timetable "Timetable"]
   [:classes "Yoga Styles"]
   [:about "About Zuri"]])

;; below navbar = 4 rem = h-16
(defn navbar [_req]
  (let [menu-open?* (h/local-signal :menu-open false)]
    [:nav {:class "fixed inset-x-0 top-0 z-50 h-16 bg-gray-50/95 dark:bg-zinc-900/95 shadow backdrop-blur"}

     [:div {:class "h-full max-w-5xl mx-auto px-4 flex items-center justify-between"}

      ;; Branding
      [:a (merge (h/navigate :home)
                 {:class "flex min-w-0 items-center gap-3 text-green-800 dark:text-green-300"})
       [:img {:src "/img/zhealth.svg"
              :alt "Z Health"
              :class "h-8 w-auto shrink-0"}]

       ;; Smaller text on phones avoids collisions with hamburger
       [:span {:class "truncate text-base sm:text-lg md:text-xl font-bold hover:text-blue-500"}
        "Yoga & Pilates with Zuri"]]

      ;; Desktop navigation
      [:div {:class "hidden md:flex items-center gap-6 text-green-800 dark:text-green-300"}
       (for [[route label] nav-items]
         [:a (merge (h/navigate route)
                    {:class "hover:text-blue-500 hover:underline"})
          label])]

      ;; Mobile menu button
      [:button {:type "button"
                :class "md:hidden shrink-0 p-2 rounded hover:bg-gray-200 dark:hover:bg-zinc-800"
                :aria-label "Toggle menu"
                :aria-controls "mobile-menu"
                :data-on:click (str @menu-open?* " = !" @menu-open?*)}
       [:svg {:xmlns "http://www.w3.org/2000/svg"
              :fill "none"
              :viewBox "0 0 24 24"
              :stroke-width "1.5"
              :stroke "currentColor"
              :class "w-6 h-6 text-green-800 dark:text-green-300"}
        [:path {:stroke-linecap "round"
                :stroke-linejoin "round"
                :d "M3.75 5.25h16.5m-16.5 6h16.5m-16.5 6h16.5"}]]]]

     ;; Mobile dropdown; close it after navigating
     [:div {:id "mobile-menu"
            :class "md:hidden absolute top-16 inset-x-0 bg-gray-50 dark:bg-zinc-900 shadow-lg border-t border-gray-200 dark:border-zinc-800"
            :style "display:none"
            :data-show @menu-open?*}
      [:ul {:class "list-none my-0 px-4 py-4 space-y-1 text-green-800 dark:text-green-300"}
       (for [[route label] (cons [:home "Home"] nav-items)]
         [:li [:a (merge (h/navigate route)
                         {:class (str "block p-3 rounded transition-colors "
                                      "hover:bg-gray-200 hover:text-blue-500 "
                                      "active:bg-gray-300 "
                                      "dark:hover:bg-zinc-800 dark:hover:text-blue-400 "
                                      "dark:active:bg-zinc-700")
                          :data-on:click (str @menu-open?* " = false")})
               label]])]]]))

(defn page-layout [req content]
  [:div
   {:class "min-h-dvh font-sans bg-zinc-50 dark:bg-zinc-900"}

   (navbar req)

   [:main {:id "main"
           :class "pt-16"}
    content]

   c/site-footer])

(defn not-found [req]
  (page-layout
   req
   [:section {:class "px-4 py-24 text-center text-green-800 dark:text-green-300"}
    [:h1 {:class "text-3xl font-bold mb-4"} "Page not found"]
    [:a (merge (h/navigate :home) {:class "link"}) "Back to the home page"]]))
