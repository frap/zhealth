(ns nz.zhealth.mailchimp)

(defn mailchimp-form []
      [:div {:id "mc_embed_shell"}
            [:link {:href "//cdn-images.mailchimp.com/embedcode/classic-061523.css"
                          :rel "stylesheet"
                          :type "text/css"}]
            [:style {:id "mc_embed_signup" :type "text/css"}
                    "{background:#fff; clear:left; font:14px Helvetica,Arial,sans-serif; width:600px;}"]
            [:div {:id "mc_embed_signup"}
                  [:form {:action "https://zhealthstudio.us4.list-manage.com/subscribe/post?u=8e9f8215afbd384350aa0257c&id=a98ad332fa&f_id=0077f9e8f0"
                                  :method "post"
                                  :id "mc-embedded-subscribe-form"
                                  :name "mc-embedded-subscribe-form"
                                  :class "validate"
                                  :target "_blank"}
                         [:div {:id "mc_embed_signup_scroll"}
                               [:h2 "Subscribe"]
                               [:div {:class "indicates-required"}
                                     [:span {:class "asterisk"} "*"]
                                     " indicates required"]
                               [:div {:class "mc-field-group"}
                                     [:label {:for "mce-EMAIL"}
                                             "Email Address "
                                             [:span {:class "asterisk"} "*"]]
                                     [:input {:type "email"
                                                    :name "EMAIL"
                                                    :class "required email"
                                                    :id "mce-EMAIL"
                                                    :required true
                                                    :value ""}]]
                               [:div {:id "mce-responses" :class "clear foot"}
                                     [:div {:class "response" :id "mce-error-response" :style "display:none;"}]
                                     [:div {:class "response" :id "mce-success-response" :style "display:none;"}]]
                               [:div {:aria-hidden "true" :style "position:absolute; left:-5000px;"}
                                     "/* real people should not fill this in and expect good things - do not remove this or risk form bot signups */"
                                     [:input {:type "text"
                                                    :name "b_8e9f8215afbd384350aa0257c_a98ad332fa"
                                                    :tabindex "-1"
                                                    :value ""}]]
                               [:div {:class "optionalParent"}
                                     [:div {:class "clear foot"}
                                           [:input {:type "submit"
                                                          :name "subscribe"
                                                          :id "mc-embedded-subscribe"
                                                          :class "button"
                                                          :value "Subscribe"}]
                                           [:p {:style "margin:0px auto;"}
                                               [:a {:href "http://eepurl.com/jcgAXY"
                                                          :title "Mailchimp - email marketing made easy and fun"}
                                                   [:span {:style "display:inline-block; background-color:transparent; border-radius:4px;"}
                                                          [:img {:class "refferal_badge"
                                                                        :src "https://digitalasset.intuit.com/render/content/dam/intuit/mc-fe/en_us/images/intuit-mc-rewards-text-dark.svg"
                                                                        :alt "Intuit Mailchimp"
                                                                        :style "width:220px; height:40px; display:flex; padding:2px 0px; justify-content:center; align-items:center;"}]]]]]]]]]
            [:script {:type "text/javascript"
                            :src "//s3.amazonaws.com/downloads.mailchimp.com/js/mc-validate.js"}]
       ;; [:script {:type "text/javascript"}
       ;; "(function($){window.fnames=new Array();window.ftypes=new Array();fnames[0]='EMAIL';ftypes[0]='email';fnames[1]='FNAME';ftypes[1]='text';fnames[2]='LNAME';ftypes[2]='text';fnames[3]='MMERGE3';ftypes[3]='text';fnames[4]='MMERGE4';ftypes[4]='text';fnames[5]='MMERGE5';ftypes[5]='text';}(jQuery));var $mcj=jQuery.noConflict(true);"]]
            ]
  )
