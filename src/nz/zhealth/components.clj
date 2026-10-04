(ns nz.zhealth.components
  (:require [hyper.core :as h]
            [nz.zhealth.mailchimp :as chimp]))

(def social-icon-class
  (str
   "w-9 h-9 shrink-0 rounded-full "
   "bg-black/40 "
   "flex items-center justify-center "
   "text-white "
   "transition duration-200 "
   "hover:scale-110 "
   "focus-visible:outline-none "
   "focus-visible:ring-2 "
   "focus-visible:ring-emerald-500"))

(def facebook-icon
  [:a {:href "https://facebook.com/zhealthstudio"
       :target "_blank"
       :rel "noopener noreferrer"
       :aria-label "Facebook"
       :class (str social-icon-class " hover:bg-blue-800/80")}
   [:svg {:xmlns "http://www.w3.org/2000/svg"
          :viewBox "0 0 24 24"
          :fill "currentColor"
          :class "h-6 w-6 text-zinc-100"}
    [:path {:d "M22 12a10 10 0 10-11.6 9.87v-6.99h-2.2V12h2.2V9.84c0-2.18 1.3-3.4 3.29-3.4.95 0 1.94.17 1.94.17v2.13h-1.09c-1.07 0-1.4.66-1.4 1.33V12h2.38l-.38 2.88h-2v6.99A10 10 0 0022 12z",
            :fill "currentColor"}]]])

(def instagram-icon
  [:a
   {:href "https://instagram.com/zuri.brudenell"
    :target "_blank"
    :rel "noopener noreferrer"
    :aria-label "Instagram"
    :class (str social-icon-class " hover:bg-pink-800/80")}
   [:svg
    {:class "w-[1.25rem] h-[1.125rem] text-white",
     :viewBox "0 0 15 15",
     :fill "none",
     :xmlns "http://www.w3.org/2000/svg"}
    [:path
     {:d "M4.70975 7.93663C4.70975 6.65824 5.76102 5.62163 7.0582 5.62163C8.35537 5.62163 9.40721 6.65824 9.40721 7.93663C9.40721 9.21502 8.35537 10.2516 7.0582 10.2516C5.76102 10.2516 4.70975 9.21502 4.70975 7.93663ZM3.43991 7.93663C3.43991 9.90608 5.05982 11.5025 7.0582 11.5025C9.05658 11.5025 10.6765 9.90608 10.6765 7.93663C10.6765 5.96719 9.05658 4.37074 7.0582 4.37074C5.05982 4.37074 3.43991 5.96719 3.43991 7.93663ZM9.97414 4.22935C9.97408 4.39417 10.0236 4.55531 10.1165 4.69239C10.2093 4.82946 10.3413 4.93633 10.4958 4.99946C10.6503 5.06259 10.8203 5.07916 10.9844 5.04707C11.1484 5.01498 11.2991 4.93568 11.4174 4.81918C11.5357 4.70268 11.6163 4.55423 11.649 4.39259C11.6817 4.23095 11.665 4.06339 11.6011 3.91109C11.5371 3.7588 11.4288 3.6286 11.2898 3.53698C11.1508 3.44536 10.9873 3.39642 10.8201 3.39635H10.8197C10.5955 3.39646 10.3806 3.48424 10.222 3.64043C10.0635 3.79661 9.97434 4.00843 9.97414 4.22935ZM4.21142 13.5892C3.52442 13.5584 3.15101 13.4456 2.90286 13.3504C2.57387 13.2241 2.33914 13.0738 2.09235 12.8309C1.84555 12.588 1.69278 12.3569 1.56527 12.0327C1.46854 11.7882 1.3541 11.4201 1.32287 10.7431C1.28871 10.0111 1.28189 9.79119 1.28189 7.93669C1.28189 6.08219 1.28927 5.86291 1.32287 5.1303C1.35416 4.45324 1.46944 4.08585 1.56527 3.84069C1.69335 3.51647 1.84589 3.28513 2.09235 3.04191C2.3388 2.79869 2.57331 2.64813 2.90286 2.52247C3.1509 2.42713 3.52442 2.31435 4.21142 2.28358C4.95417 2.24991 5.17729 2.24319 7.0582 2.24319C8.9391 2.24319 9.16244 2.25047 9.90582 2.28358C10.5928 2.31441 10.9656 2.42802 11.2144 2.52247C11.5434 2.64813 11.7781 2.79902 12.0249 3.04191C12.2717 3.2848 12.4239 3.51647 12.552 3.84069C12.6487 4.08513 12.7631 4.45324 12.7944 5.1303C12.8285 5.86291 12.8354 6.08219 12.8354 7.93669C12.8354 9.79119 12.8285 10.0105 12.7944 10.7431C12.7631 11.4201 12.6481 11.7881 12.552 12.0327C12.4239 12.3569 12.2714 12.5882 12.0249 12.8309C11.7784 13.0736 11.5434 13.2241 11.2144 13.3504C10.9663 13.4457 10.5928 13.5585 9.90582 13.5892C9.16306 13.6229 8.93994 13.6296 7.0582 13.6296C5.17645 13.6296 4.95395 13.6229 4.21142 13.5892ZM4.15307 1.03424C3.40294 1.06791 2.89035 1.18513 2.4427 1.3568C1.9791 1.53408 1.58663 1.77191 1.19446 2.1578C0.802277 2.54369 0.56157 2.93108 0.381687 3.38797C0.207498 3.82941 0.0885535 4.3343 0.0543922 5.07358C0.0196672 5.81402 0.0117188 6.05074 0.0117188 7.93663C0.0117188 9.82252 0.0196672 10.0592 0.0543922 10.7997C0.0885535 11.539 0.207498 12.0439 0.381687 12.4853C0.56157 12.9419 0.802334 13.3297 1.19446 13.7155C1.58658 14.1012 1.9791 14.3387 2.4427 14.5165C2.89119 14.6881 3.40294 14.8054 4.15307 14.839C4.90479 14.8727 5.1446 14.8811 7.0582 14.8811C8.9718 14.8811 9.212 14.8732 9.96332 14.839C10.7135 14.8054 11.2258 14.6881 11.6737 14.5165C12.137 14.3387 12.5298 14.1014 12.9219 13.7155C13.3141 13.3296 13.5543 12.9419 13.7347 12.4853C13.9089 12.0439 14.0284 11.539 14.062 10.7997C14.0962 10.0587 14.1041 9.82252 14.1041 7.93663C14.1041 6.05074 14.0962 5.81402 14.062 5.07358C14.0278 4.33424 13.9089 3.82913 13.7347 3.38797C13.5543 2.93135 13.3135 2.5443 12.9219 2.1578C12.5304 1.7713 12.137 1.53408 11.6743 1.3568C11.2258 1.18513 10.7135 1.06735 9.96388 1.03424C9.21256 1.00058 8.97236 0.992188 7.05876 0.992188C5.14516 0.992188 4.90479 1.00002 4.15307 1.03424Z",
      :fill "currentColor"}]]])

(def youtube-url "https://www.youtube.com/@zhealthstudio9803")

(def youtube-icon
  [:a
   {:href youtube-url
    :target "_blank"
    :rel "noopener noreferrer"
    :aria-label "YouTube"
    :class (str social-icon-class " hover:bg-rose-600/80")}
   [:svg {:class "w-[1.25rem] h-[0.875rem] text-white",
          :viewBox "0 0 16 12",
          :fill "none",
          :xmlns "http://www.w3.org/2000/svg"}
    [:path
     {:fill-rule "evenodd",
      :clip-rule "evenodd",
      :d "M13.9346 1.13529C14.5684 1.30645 15.0665 1.80588 15.2349 2.43896C15.5413 3.58788 15.5413 5.98654 15.5413 5.98654C15.5413 5.98654 15.5413 8.3852 15.2349 9.53412C15.0642 10.1695 14.5661 10.669 13.9346 10.8378C12.7886 11.1449 8.19058 11.1449 8.19058 11.1449C8.19058 11.1449 3.59491 11.1449 2.44657 10.8378C1.81277 10.6666 1.31461 10.1672 1.14622 9.53412C0.839844 8.3852 0.839844 5.98654 0.839844 5.98654C0.839844 5.98654 0.839844 3.58788 1.14622 2.43896C1.31695 1.80353 1.81511 1.30411 2.44657 1.13529C3.59491 0.828125 8.19058 0.828125 8.19058 0.828125C8.19058 0.828125 12.7886 0.828125 13.9346 1.13529ZM10.541 5.98654L6.72178 8.19762V3.77545L10.541 5.98654Z",
      :fill "currentColor"}]]])

(def email-icon
  [:a
   {:href "mailto:zuri@zhealth.nz"
    :aria-label "Email"
    :class (str social-icon-class " hover:bg-orange-600/80")}
   [:svg {:xmlns "http://www.w3.org/2000/svg"
          :viewBox "0 0 24 24"
          :fill "currentColor"
          :class "h-6 w-6 text-white"}
    [:path {:d "M1.5 4.5A2.25 2.25 0 0 1 3.75 2.25h16.5A2.25 2.25 0 0 1 22.5 4.5v15a2.25 2.25 0 0 1-2.25 2.25H3.75A2.25 2.25 0 0 1 1.5 19.5v-15zm2.25-.75a.75.75 0 0 0-.75.75v.384l9 5.625 9-5.625V4.5a.75.75 0 0 0-.75-.75H3.75zm17.25 3.036-7.934 4.958a1.5 1.5 0 0 1-1.632 0L3.75 6.786V19.5a.75.75 0 0 0 .75.75h15a.75.75 0 0 0 .75-.75V6.786z"}]]])

(def phone-icon
  [:a
   {:href "tel:+64211315510"
    :aria-label "Phone"
    :class (str social-icon-class " hover:bg-yellow-400/80")}
   [:svg {:xmlns "http://www.w3.org/2000/svg"
          :viewBox "0 0 24 24"
          :fill "currentColor"
          :class "h-6 w-6 text-white"}
    [:path {:d "M2.25 4.5a.75.75 0 0 1 .75-.75h3.246a.75.75 0 0 1 .735.606l.768 3.84a.75.75 0 0 1-.21.705L6.25 10.94a12.005 12.005 0 0 0 6.81 6.81l1.038-1.29a.75.75 0 0 1 .705-.21l3.84.768a.75.75 0 0 1 .606.735V21a.75.75 0 0 1-.75.75H19.5A16.5 16.5 0 0 1 3 5.25V4.5z"}]]])

(def site-footer
  [:footer
   {:class
    "w-full bg-gray-50 dark:bg-zinc-900 text-green-800 dark:text-green-300 border-t border-gray-200 dark:border-zinc-800"}

   [:div
    {:class
     (str
      "max-w-5xl mx-auto px-4 py-5 "
      "flex flex-col sm:flex-row "
      "items-center justify-between "
      "gap-4")}

    [:div {:class "flex items-center gap-2"}
     [:span {:class "italic text-sm"}
      "since 2012"]

     [:img {:src "/img/zhealth_logo.webp"
            :alt "Z Health"
            :class "h-8 w-auto"}]]

    [:div {:class "flex items-center justify-center gap-3"}
     email-icon
     facebook-icon
     instagram-icon
     youtube-icon
     phone-icon]]])

(def carousel
  [:section
   {:class "w-full bg-gray-100 dark:bg-zinc-900 py-8"}

   [:div {:class "max-w-3xl mx-auto px-4"}

    [:div
     {:class "carousel relative h-64 sm:h-80 md:h-96 overflow-hidden rounded-xl shadow-lg"}

     [:img
      {:src "/img/childs-pose-kapiti.webp"
       :alt "Child's Pose"
       :class "carousel-slide"}]

     [:img
      {:src "/img/namaste.webp"
       :alt "Namaste"
       :class "carousel-slide"}]

     [:img
      {:src "/img/swiss-ball.webp"
       :alt "Swiss Ball"
       :class "carousel-slide"}]]]])

(defn about []
  (let [newsletter?* (h/local-signal :newsletter false)]
  [:section {:id "about"
             :class "scroll-mt-16 px-4 py-12 bg-gray-50 dark:bg-zinc-900"}
   [:div {:class "max-w-5xl mx-auto"}

    [:h2 {:class "text-3xl md:text-4xl font-bold text-center mb-12 text-green-800 dark:text-green-300"}
     "🌿 About Zuri"]

    [:div {:class "font-bold text-xl text-center text-gray-600 dark:text-gray-400"}
     [:p "Offering high quality Yoga and Pilates classes in the heart of the Kāpiti Coast since 2012"]
     [:p "– and now, online too!"]]

    [:p {:class "mb-4 text-gray-600 dark:text-gray-400"}
     "Zuri is an award-winning teacher with over thirty years of experience in the exercise industry. Zuri’s qualifications include Exercise to Music, Aerobics, Step, Swiss Ball, Yoga, Zumba, Pilates, Yin Yoga, as well as Personal Training and Fitness Assessment. She is also a member of the NZ Register of Exercise Professionals and brings a wealth of knowledge to every practise."]
    ;; Intro block

    [:div {:class "flex flex-col md:flex-row gap-6 mb-12 text-gray-600 dark:text-gray-400"}
     [:div {:class "md:w-1/3 flex justify-center"}
      [:img {:src "img/namaste.webp"
             :alt "Zuri Namaste"
             :class "rounded-lg shadow-lg max-w-xs"}]]
     [:div {:class "md:w-2/3"}
      [:p {:class "mb-4"}
       "With her background in modern contemporary dance paired with a passion for health and fitness, Zuri has the energy and passion to support you on your wellbeing journey. A mother of three, and now fit and fabulous in her fifties, Zuri has a breadth of understanding on how to balance work, rest and play."]
      [:p {:class "italic text-gray-600 dark:text-gray-400"}
       "“When I was young, I strived to push myself through dance and exercise, but after discovering Yoga in 1998 I began to slow down – finding a softness in my mind and body. While my body has not changed much in the last thirty years, I have learnt that the key to good health is how I feel. Through Pilates, I have found strength in stillness – learning that a deep connection to my body allows me to move with grace, flow and beauty. It is my passion to show everyone this same freedom of movement."]]]

;; Award + mission block
    [:div {:class "flex flex-col md:flex-row gap-6 text-gray-600 dark:text-gray-400"}
     [:div {:class "md:w-1/3 flex justify-center"}
      [:img {:src "img/yoga-teacher-of-year.webp"
             :alt "Yoga teacher of the year award"
             :class "rounded-lg shadow-lg max-w-xs"}]]
     [:div {:class "md:w-2/3"}
      [:p {:class "mb-4"}
       "In 2012, Zuri founded Z Health with a simple dream: to offer mindful movement centred on breath, flow, and presence. Her classes gently guide you back to your own rhythm — helping you build strength, awareness, and ease in both body and mind."]
      [:p {:class "mb-4"}
       [:span {:class "font-semibold"} "In 2021, she was honoured as Yoga Teacher of the Year"] " — a reflection of her deeply personal and supportive approach. Her students describe her as intuitive, kind, and inspiring — someone who truly listens and meets people where they are."]
      [:p
       "Zuri is passionate about giving you the space to reconnect with your own internal power and physical strength as she guides you through this journey. Zuri believes that, like her, we can all live a life of balance, pleasure, and strength through learning how to prioritise our wellbeing and value the fluidity of movement."]]]
     ;; --- Newsletter block at the end ---
    [:section  {:class "flex justify-center mt-12 mb-24"}

     ;; Teaser button swaps itself for the signup form (client-side signal)
     [:div {:id "newsletter-teaser"
            :data-show (str "!" @newsletter?*)}
      [:button {:type "button"
                :class "inline-block self-center md:self-end px-6 py-3 text-xl rounded-2xl md:mt-0 md:mb-0 mb-8 font-semibold shadow-md bg-emerald-600 hover:bg-emerald-700 active:bg-emerald-800 transition-colors duration-300 text-white"
                :aria-label "Show Mailchimp signup form"
                :data-on:click (str @newsletter?* " = true")}
       "Click here to join our Community Newsletter!"]]
     [:div {:id "newsletter-signup"
            :class "w-full"
            :style "display:none"
            :data-show @newsletter?*}
      chimp/mailchimp-form]]]]))

(def hero-section
  [:section
   {:id "hero"
    :class
    (str
     "relative "
     "min-h-[calc(100dvh-4rem)] "
     "overflow-hidden "
     "bg-[url(/img/kapiti-1920.webp)] "
     "bg-cover bg-center bg-no-repeat "
     "scroll-mt-16")}

   ;; Background darkening layer
   [:div {:class "absolute inset-0 bg-black/20"}]

   ;; Hero content
   [:div
    {:class
     (str
      "relative z-10 "
      "mx-auto "
      "flex min-h-[calc(100dvh-4rem)] "
      "w-full max-w-5xl flex-col "
      "items-center text-center "
      "px-5 sm:px-8 "
      "pt-10 sm:pt-14 md:pt-20 "
      "pb-5 md:pb-8")}

    [:h1
     {:class
      (str
       "max-w-4xl "
       "text-3xl sm:text-4xl md:text-6xl "
       "font-bold leading-tight "
       "text-white drop-shadow-md")}
     "“In "
     [:em "stillness,"]
     " we find "
     [:em {:class "animate-fade-in"} "strength"]
     "“"]

    [:div {:class "mt-6 md:mt-8 space-y-2"}
     [:p {:class "text-lg sm:text-xl md:text-3xl text-white drop-shadow"}
      "Movement • Mindfulness • Creativity"]

     [:p {:class "text-base sm:text-lg md:text-2xl text-white drop-shadow"}
      "Move your Body. Calm your Mind. Find your Flow."]]

    ;; Push this group to bottom
    [:div
     {:class
      "mt-auto flex flex-col items-center gap-1 animate-fade-in"}

     [:img
      {:src "/img/zhealth-wwatermark.webp"
       :alt "Z Health"
       :class "h-12 sm:h-14 md:h-16 w-auto"}]

     [:p {:class "m-0 text-base md:text-lg text-white drop-shadow"}
      "since 2012"]]]])

(defn class-block [title desc details img-src]
  [:div
   {:class
    (str
     "flex flex-col md:flex-row "
     "items-center md:items-center "
     "gap-6 md:gap-10 "
     "mb-12")}

   [:div {:class "w-full md:w-1/3 flex justify-center"}
    [:img {:src img-src
           :alt title
           :loading "lazy"
           :class "w-full max-w-xs rounded-xl shadow-lg"}]]

   [:div {:class "w-full md:w-2/3 text-center md:text-left"}
    [:h3 {:class "text-2xl font-semibold text-green-800 dark:text-green-300 mb-3"}
     title]

    ;; desc is a single paragraph or a vector of paragraphs (strings or hiccup)
    (for [para (if (string? desc) [desc] desc)]
      [:p {:class "text-zinc-700 dark:text-zinc-300 mb-3 leading-relaxed"}
       para])

    (for [line details]
      [:p {:class "text-sm italic text-gray-600 dark:text-gray-400"}
       line])]])

(def book-a-class
  [:a
   {:href "https://bookings.gettimely.com/zhealthstudio/bb/book"
    :target "_blank"
    :rel "noopener noreferrer"
    :class
    (str
     "inline-flex items-center justify-center "
     "px-5 py-3 "
     "font-semibold text-base md:text-lg "
     "rounded-xl shadow-md "
     "bg-emerald-600 hover:bg-emerald-700 active:bg-emerald-800 "
     "transition-colors text-white")}
   "Book a class"])

(def classes-section
  [:section {:id "classes"
             :class "px-4 py-12 scroll-mt-16 bg-gray-50 dark:bg-zinc-900"}
   [:div {:class "max-w-5xl mx-auto"}

    [:div {:class
           "flex flex-col md:flex-row items-center md:justify-between gap-4 mb-10"}

     [:h2 {:class
           "text-3xl md:text-4xl font-bold text-center md:text-left text-green-800 dark:text-green-300"}
      "Z Health Classes"]

     book-a-class]

                ;; Each class block
    (class-block
     "Yin Yoga"
     "Yin Yoga is “the other half” of yoga. A slow-paced practice with long-held asanas to stimulate the fascia and release deep-seated tension, de-stressing the mind and re-energizing the soul. Suitable for all levels."
     []
     "img/childs-pose.webp")

    (class-block
     "Yoga Flow"
     "A dynamic yoga practice aiming to rejuvenate the body and free the mind from tension and fatigue. Serves as an introduction to traditional forms of Yoga through physical postures."
     []
     "img/warrior.webp")

    (class-block
     "Pilates"
     "The Classical Pilates mat practice is a unique sequence of exercises designed by Joseph Pilates, incorporating dynamic moves to tone and strengthen the whole body while improving postural alignment and flexibility."
     []
     "img/pilates.webp")

    (class-block
     "Yogilates"
     [[:strong "Yoga + Pilates = the best of both worlds."]
      "A combination of strengthening Pilates movements, Yoga stretches, balance work, mobility and relaxation."
      "Ideal for those new to Yoga and/or Pilates. Introduces basic Pilates principles and incorporates Yoga postures and breath to reconnect the mind, body, and soul."
      [:strong "One of my most popular classes!"]]
     []
     "img/childs-pose-kapiti.webp")

    (class-block
     "Online Yoga & Meditation"
     "Can't make it to a class?"
     ["Join me from home with online practices designed to help you move, stretch, breathe and relax."
      [:a {:href youtube-url
           :target "_blank"
           :rel "noopener noreferrer"
           :class "not-italic font-semibold text-emerald-700 hover:underline dark:text-emerald-400"}
       "Watch my free classes on YouTube"]]
     "img/fish-zen-sq.webp")]])

(def why-zhealth
  [:section {:id "why"
             :class "px-4 py-12 scroll-mt-16 bg-gray-50 dark:bg-zinc-900"}
   [:div {:class "max-w-5xl mx-auto"}

    [:h2 {:class "text-3xl md:text-4xl font-bold text-center mb-12 text-green-800 dark:text-green-300"}
     "🌿 Why Z Health?"]

    [:div  {:class "mb-4 text-l text-gray-600 dark:text-gray-400"}
     [:p "✔ 35+ years teaching movement & exercise"]
     [:p "✔ 14+ years of Z Health on the Kāpiti Coast"]
     [:p "✔ NZ Exercise Association Yoga Teacher of the Year 2021"]
     [:p "✔ Qualified Yoga & Pilates teacher"]
     [:p "✔ Welcoming, supportive classes"]
     [:p "✔ A strong focus on 50+ wellbeing"]
     [:p "✔ Small, friendly local community"]
     [:p "✔ In-person & online options"]
     [:p "✔ Classes designed for real people and real bodies"]]

    [:div  {:class "mb-4 font-bold text-l text-gray-600 dark:text-gray-400"}
     [:p "Experienced enough to know the body."]
     [:p "Passionate enough to keep learning."]
     [:p "Curious enough to keep creating."]]]])

(def timetable-section
  [:section {:id "timetable"
             :class "px-4 py-12 scroll-mt-16 bg-gray-50 dark:bg-zinc-900"} ;;bg-no-repeat bg-contain bg-center bg-[url(/img/fish-zen.webp)]
   [:div {:class "max-w-5xl mx-auto"}

    [:div {:class "flex flex-col md:flex-row md:items-center md:justify-between mb-4"}
     [:h2 {:class "text-3xl md:text-4xl font-bold text-center md:text-left text-green-800 dark:text-green-300"}
      "Class Timetable"]
     book-a-class]

    ;; Table view for md+ screens
    [:div {:class "hidden md:block overflow-x-auto"}
     [:table {:class "min-w-full table-fixed border border-green-200 dark:border-green-700"}
      [:thead {:class "bg-green-100 dark:bg-green-900"}
       [:tr
        [:th {:class "p-2 border text-left text-green-900 dark:text-green-100 text-sm md:text-base"} "Time"]
        (for [day ["Monday" "Tuesday" "Thursday" "Saturday"]]
          [:th {:class "p-2 border text-center text-green-900 dark:text-green-100 text-sm md:text-base"} day])]]
      [:tbody
       (for [[time slots]
             [["8.45am" ["", "", "", ["Yoga Flow" "Raumati South Memorial Hall"]]]
              ["9.30am" ["",
                         ["Yogilates (online)" "Paraparaumu Memorial Hall "],
                         ["Yogilates (online)" "Paraparaumu Memorial Hall"],
                         ""]]
              ["10am" ["", "", "", ["Pilates" "Raumati South Memorial Hall"]]]
              ["6pm" [["Yin Yoga" "(online)"], "", "", ""]]]]
         [:tr
          [:td {:class "p-2 border text-green-900 dark:text-green-100 font-semibold text-sm md:text-base"} time]
          (for [slot slots]
            [:td {:class "p-2 border dark:border-green-700"}
             (when (vector? slot)
               [:div {:class "bg-green-700 dark:bg-green-800 text-white text-center font-medium px-2 py-1 rounded shadow-sm"}
                [:div {:class "text-sm md:text-base"} (first slot)]
                [:div {:class "text-xs italic text-gray-200"} (second slot)]])])])]]]

    ;; Mobile stacked layout by day
    [:div {:class "md:hidden space-y-6"}
     (for [[day entries]
           [["Monday"
             [["6pm" "Yin Yoga" "(online)"]]]

            ["Tuesday"
             [["9.30am" "Yogilates"
               "Paraparaumu Memorial Hall (+ online)"]]]

            ["Thursday"
             [["9.30am" "Yogilates"
               "Paraparaumu Memorial Hall (+ online)"]]]

            ["Saturday"
             [["8.45am" "Yoga Flow"
               "Raumati South Memorial Hall"]
              ["10am" "Pilates"
               "Raumati South Memorial Hall"]]]]]
       [:div {:class "bg-white dark:bg-zinc-800 rounded shadow p-4"}
        [:div {:class "text-green-900 dark:text-green-100 font-bold text-xl mb-2"} day]
        (for [[time class location] entries]
          [:div {:class "mb-3"}
           [:div {:class "text-sm text-green-800 dark:text-green-300 font-semibold"} time]
           [:div {:class "text-base font-medium dark:text-white"} class]
           [:div {:class "text-sm italic text-gray-600 dark:text-gray-400"} location]])])]

    ;; [:div {:class "flex justify-center mt-4"}
    ;;  [:img {:src "/img/zhealth_logo.webp" :alt "Z Health" :class "rounded-lg shadow-lg w-full max-w-xs"}]]
    ]])
