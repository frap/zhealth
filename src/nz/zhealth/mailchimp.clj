(ns nz.zhealth.mailchimp)

;; Embedded Mailchimp signup form, styled with Tailwind.
(def mailchimp-form
  [:section {:id "mc_embed_shell"}
   [:div {:id "mc_embed_signup"
          :class "mx-auto w-full max-w-xl rounded-md border border-zinc-200 bg-white p-6 shadow-sm dark:border-zinc-700 dark:bg-zinc-800"}
    [:h3 {:class "mb-2 text-2xl font-semibold text-green-800 dark:text-green-300"}
     "Subscribe"]
    [:p {:class "mb-4 text-sm text-zinc-600 dark:text-zinc-400"}
     [:span {:class "text-red-600"} "*"] " indicates required"]

    [:form {:action "https://zhealthstudio.us4.list-manage.com/subscribe/post?u=8e9f8215afbd384350aa0257c&id=a98ad332fa&f_id=0077f9e8f0"
            :method "post"
            :id "mc-embedded-subscribe-form"
            :name "mc-embedded-subscribe-form"
            :class "space-y-4"
            :target "_blank"
            :noValidate true}

     ;; Email
     [:div
      [:label {:for "mce-EMAIL"
               :class "mb-1 block text-sm font-medium text-zinc-700 dark:text-zinc-200"}
       "Email Address " [:span {:class "text-red-600"} "*"]]
      [:input {:type "email" :name "EMAIL" :id "mce-EMAIL" :required true
               :class "block w-full rounded-md border border-zinc-300 px-3 py-2
                        text-zinc-900 placeholder-zinc-400
                        focus:border-green-500 focus:outline-none focus:ring-2 focus:ring-green-500
                        dark:border-zinc-700 dark:bg-zinc-900 dark:text-zinc-100"}]]

     ;; Submit row
     [:div {:class "flex items-center justify-between pt-1"}
      [:button {:type "submit" :name "subscribe" :id "mc-embedded-subscribe"
                :class "inline-flex items-center rounded-md bg-green-700 px-5 py-2.5
                         font-medium text-white hover:bg-green-800 active:bg-green-900"}
       "Subscribe"]
      [:a {:href "http://eepurl.com/jcgAXY"
           :title "Mailchimp - email marketing made easy and fun"
           :class "ml-4 inline-flex items-center"}
       [:img {:class "h-8 w-auto opacity-80"
              :alt "Intuit Mailchimp"
              :src "https://digitalasset.intuit.com/render/content/dam/intuit/mc-fe/en_us/images/intuit-mc-rewards-text-dark.svg"}]]]

     ;; Response placeholders (kept for MC)
     [:div {:id "mce-responses" :class "hidden"}
      [:div {:class "response" :id "mce-error-response"}]
      [:div {:class "response" :id "mce-success-response"}]]

     ;; Honeypot: hidden from users, present for bots
     [:div {:aria-hidden "true"
            :class "sr-only"}            ;; visually hidden but still in DOM
      [:input {:type "text"
               :name "b_8e9f8215afbd384350aa0257c_a98ad332fa"
               :tabIndex "-1" :value ""}]]]]])
