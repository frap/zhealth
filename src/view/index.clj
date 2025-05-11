(ns view.index
  (:require
   [view.layout :as l]
   [database.user :as user]))

(defn gallery
  []
  [:section {:class "bg-zinc-50 py-20"}
   [:div {:class ["max-w-7xl" "mx-auto" "px-4" "sm:px-6" "lg:px-8"]   }
    [:h2 {:class ["text-3xl" "font-bold" "text-slate-300" "mb-8"]} "Z Health in Action"]
    [:div {:class ["grid" "grid-cols-1" "sm:grid-cols-2" "md:grid-cols-3" "gap-6"]}
     (for [img-src ["/static/images/Zflow.webp" "/static/images/Zswissball.webp" "/static/images/ZWarrior.webp"
                    "/static/images/Zstar.webp" "/static/images/Zchild-pose.webp" "/static/images/yoga-hero.png" ]]
       [:div {:class ["overflow-hidden" "rounded-lg" "shadow-lg"]}
        [:img {:src img-src
               :alt "Yoga classes"
               :class ["w-full" "h-64" "object-cover" "hover:scale-105" "transition-transform" "duration-300"]}]])]]])

(defn carousel [current-index]
  (let [images ["/static/images/Zflow.webp"
                "/static/images/Zswissball.png"
                "/static/images/Zstar.webp"
                "/static/images/Zchild-pose.webp"]
        total (count images)
        index (mod current-index total)
        prev-index (mod (dec current-index) total)
        next-index (mod (inc current-index) total)
        current-src (nth images index)]
    [:div {:class ["relative" "w-full" "max-w-2xl" "mx-auto"]}
     [:img {:src current-src
            :alt "Yoga Studio"
            :class ["w-full" "h-96" "object-cover" "rounded-lg" "shadow-lg" "transition-all" "duration-300"]}]
     ;; Prev button
     [:button {:class ["absolute" "top-1/2" "-left-4" "transform" "-translate-y-1/2"
                       "bg-white" "text-gray-800" "p-2" "rounded-full" "shadow"
                       "hover:bg-gray-100"]
               :hx-get (str "/carousel-images/" prev-index)
               :hx-target "closest div"
               :hx-swap "outerHTML"}
      "←"]
     ;; Next button
     [:button {:class ["absolute" "top-1/2" "-right-4" "transform" "-translate-y-1/2"
                       "bg-white" "text-gray-800" "p-2" "rounded-full" "shadow"
                       "hover:bg-gray-100"]
               :hx-get (str "/carousel-images/" next-index)
               :hx-target "closest div"
               :hx-swap "outerHTML"}
      "→"]]))


(def hero
  [:section {:class "bg-zinc-50 py-20"}
   [:div {:class "max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 flex flex-col md:flex-row items-center"}
    [:div {:class "text-center md:text-left md:w-1/2"}
     [:h1 {:class "text-4xl font-extrabold text-gray-900 sm:text-5xl"}
      "Z Health Yoga & Pilates - Find Your Inner Peace"]
     [:p {:class "mt-4 text-lg text-gray-600"}
      "Join our community to explore yoga, mindfulness, and holistic wellness."]
     [:div {:class "mt-6"}
      [:a {:href "#"
           :class "inline-block bg-cyan-300 text-white py-3 px-6 rounded-md text-lg font-medium hover:bg-cyan-700 transition"}
       "Join a Class"]]]
    [:div {:class "mt-10 md:mt-0 md:w-1/2 flex justify-center"}
     [:img {:src "/static/images/Znamaste.webp"
            :alt "Yoga pose"
            :class "w-full h-auto max-w-md rounded-lg border border-gray-300 shadow-lg hover:shadow-xl transition-shadow duration-300"}]]
    ]])

(defn page [req]
  (let [user (try
               (user/by-id
                (Integer.
                 (get-in req [:session :user-id] -1)))
               (catch Exception _ nil))]
    (l/layout
     req
     [:div.container
      hero
       (gallery)
      ]
    )))
