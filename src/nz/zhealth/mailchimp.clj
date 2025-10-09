(ns nz.zhealth.mailchimp
  (:require [rum.core :as rum]
            [ring.util.response :as resp]))

;; Rum component (hiccup-like syntax is fine)
;; (rum/defc MailchimpForm []
;;   [:div {:id "mc_embed_shell"}
;;    [:link {:href "//cdn-images.mailchimp.com/embedcode/classic-061523.css"
;;            :rel "stylesheet" :type "text/css"}]
;;    [:div {:id "mc_embed_signup"
;;           :style { :type "text/css" :background "#fff" :font "14px Helvetica,Arial,sans-serif" :width "600px" :clear "left"}}
;;          [:form {:action "https://zhealthstudio.us4.list-manage.com/subscribe/post?u=8e9f8215afbd384350aa0257c&id=a98ad332fa&f_id=0077f9e8f0"
;;                          :method "post" :id "mc-embedded-subscribe-form"
;;                          :name "mc-embedded-subscribe-form" :class "validate" :target "_blank"}
;;                 [:div {:id "mc_embed_signup_scroll"}
;;                       [:h2 "Subscribe"]
;;                       [:div {:class "indicates-required"}
;;                             [:span {:class "asterisk"} "*"] " indicates required"]
;;                       [:div {:class "mc-field-group"}
;;                             [:label {:for "mce-EMAIL"} "Email Address " [:span {:class "asterisk"} "*"]]
;;                             [:input {:type "email" :name "EMAIL" :class "required email"
;;                                            :id "mce-EMAIL" :required true :value ""}]]
;;                       [:div {:id "mce-responses" :class "clear foot"}
;;                             [:div {:class "response" :id "mce-error-response"  :style {:display "none"}}]
;;                             [:div {:class "response" :id "mce-success-response" :style {:display "none"}}]]
;;                       [:div {:aria-hidden "true" :style {:position "absolute" :left "-5000px"}}
;;                             "/* real people should not fill this in and expect good things - do not remove this or risk form bot signups */"
;;                             [:input {:type "text"
;;                                            :name "b_8e9f8215afbd384350aa0257c_a98ad332fa"
;;                                            :tabindex "-1" :value ""}]]
;;                       [:div {:class "optionalParent"}
;;                             [:div {:class "clear foot"}
;;                                   [:input {:type "submit" :name "subscribe" :id "mc-embedded-subscribe"
;;                                                  :class "button" :value "Subscribe"}]
;;                                   [:p {:style {:margin "0px auto"}}
;;                                       [:a {:href "http://eepurl.com/jcgAXY"
;;                                                  :title "Mailchimp - email marketing made easy and fun"}
;;                                           [:span {:style {:display "inline-block"
;;                                                           :background-color "transparent"
;;                                                           :border-radius "4px"}}
;;                                                  [:img {:class "refferal_badge"
;;                                                                :src "https://digitalasset.intuit.com/render/content/dam/intuit/mc-fe/en_us/images/intuit-mc-rewards-text-dark.svg"
;;                                                                :alt "Intuit Mailchimp"
;;                                                                :style {:width "220px" :height "40px" :display "flex"
;;                                                                               :padding "2px 0px" :justify-content "center"
;;                                                                               :align-items "center"}}]]]]]]]]]
;;    [:script {:type "text/javascript"
;;                    :src "//s3.amazonaws.com/downloads.mailchimp.com/js/mc-validate.js"}]
;;    [:script {:type "text/javascript"}
;;     "(function($){window.fnames=new Array();window.ftypes=new Array();fnames[0]='EMAIL';ftypes[0]='email';fnames[1]='FNAME';ftypes[1]='text';fnames[2]='LNAME';ftypes[2]='text';fnames[3]='MMERGE3';ftypes[3]='text';fnames[4]='MMERGE4';ftypes[4]='text';fnames[5]='MMERGE5';ftypes[5]='text';}(jQuery));var $mcj=jQuery.noConflict(true);"]]
;;   )
(rum/defc MailchimpForm []
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


(defn mailchimp-form-handler [_req]
  ;; Render Rum -> static HTML and return as a Ring response
      (-> (resp/response (rum/render-static-markup (MailchimpForm)))
          (resp/content-type "text/html; charset=utf-8")))
