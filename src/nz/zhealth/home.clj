(ns nz.zhealth.home
  (:require [nz.zhealth.ui :as ui]
))

(def facebook-icon
  [:a
   {:href "https://facebook.com/zhealthstudio" :target "_blank" :aria-label "Facebook"
    :class "w-9 h-9 rounded-full bg-black/40 hover:bg-blue-800/80  flex justify-center items-center  transform transition-transform duration-200 hover:scale-110 text-zinc-100"}
   [:svg {:xmlns "http://www.w3.org/2000/svg"
          :viewBox "0 0 24 24"
          :fill "currentColor"
          :class "h-6 w-6 text-zinc-100"}
    [:path {:d "M22 12a10 10 0 10-11.6 9.87v-6.99h-2.2V12h2.2V9.84c0-2.18 1.3-3.4 3.29-3.4.95 0 1.94.17 1.94.17v2.13h-1.09c-1.07 0-1.4.66-1.4 1.33V12h2.38l-.38 2.88h-2v6.99A10 10 0 0022 12z",
            :fill "currentColor" }]]])


(def instagram-icon
  [:a
   {:href "https://instagram.com/zuri.brudenell" :aria-label "Instagram"
    :class "w-9 h-9 rounded-full bg-black/40 hover:bg-pink-800/80  flex justify-center items-center transform transition-transform duration-200 hover:scale-110 text-zinc-100"}
   [:svg
    {:class "w-[1.25rem] h-[1.125rem] text-white",
     :viewBox "0 0 15 15",
     :fill "none",
     :xmlns "http://www.w3.org/2000/svg"}
    [:path
     {:d "M4.70975 7.93663C4.70975 6.65824 5.76102 5.62163 7.0582 5.62163C8.35537 5.62163 9.40721 6.65824 9.40721 7.93663C9.40721 9.21502 8.35537 10.2516 7.0582 10.2516C5.76102 10.2516 4.70975 9.21502 4.70975 7.93663ZM3.43991 7.93663C3.43991 9.90608 5.05982 11.5025 7.0582 11.5025C9.05658 11.5025 10.6765 9.90608 10.6765 7.93663C10.6765 5.96719 9.05658 4.37074 7.0582 4.37074C5.05982 4.37074 3.43991 5.96719 3.43991 7.93663ZM9.97414 4.22935C9.97408 4.39417 10.0236 4.55531 10.1165 4.69239C10.2093 4.82946 10.3413 4.93633 10.4958 4.99946C10.6503 5.06259 10.8203 5.07916 10.9844 5.04707C11.1484 5.01498 11.2991 4.93568 11.4174 4.81918C11.5357 4.70268 11.6163 4.55423 11.649 4.39259C11.6817 4.23095 11.665 4.06339 11.6011 3.91109C11.5371 3.7588 11.4288 3.6286 11.2898 3.53698C11.1508 3.44536 10.9873 3.39642 10.8201 3.39635H10.8197C10.5955 3.39646 10.3806 3.48424 10.222 3.64043C10.0635 3.79661 9.97434 4.00843 9.97414 4.22935ZM4.21142 13.5892C3.52442 13.5584 3.15101 13.4456 2.90286 13.3504C2.57387 13.2241 2.33914 13.0738 2.09235 12.8309C1.84555 12.588 1.69278 12.3569 1.56527 12.0327C1.46854 11.7882 1.3541 11.4201 1.32287 10.7431C1.28871 10.0111 1.28189 9.79119 1.28189 7.93669C1.28189 6.08219 1.28927 5.86291 1.32287 5.1303C1.35416 4.45324 1.46944 4.08585 1.56527 3.84069C1.69335 3.51647 1.84589 3.28513 2.09235 3.04191C2.3388 2.79869 2.57331 2.64813 2.90286 2.52247C3.1509 2.42713 3.52442 2.31435 4.21142 2.28358C4.95417 2.24991 5.17729 2.24319 7.0582 2.24319C8.9391 2.24319 9.16244 2.25047 9.90582 2.28358C10.5928 2.31441 10.9656 2.42802 11.2144 2.52247C11.5434 2.64813 11.7781 2.79902 12.0249 3.04191C12.2717 3.2848 12.4239 3.51647 12.552 3.84069C12.6487 4.08513 12.7631 4.45324 12.7944 5.1303C12.8285 5.86291 12.8354 6.08219 12.8354 7.93669C12.8354 9.79119 12.8285 10.0105 12.7944 10.7431C12.7631 11.4201 12.6481 11.7881 12.552 12.0327C12.4239 12.3569 12.2714 12.5882 12.0249 12.8309C11.7784 13.0736 11.5434 13.2241 11.2144 13.3504C10.9663 13.4457 10.5928 13.5585 9.90582 13.5892C9.16306 13.6229 8.93994 13.6296 7.0582 13.6296C5.17645 13.6296 4.95395 13.6229 4.21142 13.5892ZM4.15307 1.03424C3.40294 1.06791 2.89035 1.18513 2.4427 1.3568C1.9791 1.53408 1.58663 1.77191 1.19446 2.1578C0.802277 2.54369 0.56157 2.93108 0.381687 3.38797C0.207498 3.82941 0.0885535 4.3343 0.0543922 5.07358C0.0196672 5.81402 0.0117188 6.05074 0.0117188 7.93663C0.0117188 9.82252 0.0196672 10.0592 0.0543922 10.7997C0.0885535 11.539 0.207498 12.0439 0.381687 12.4853C0.56157 12.9419 0.802334 13.3297 1.19446 13.7155C1.58658 14.1012 1.9791 14.3387 2.4427 14.5165C2.89119 14.6881 3.40294 14.8054 4.15307 14.839C4.90479 14.8727 5.1446 14.8811 7.0582 14.8811C8.9718 14.8811 9.212 14.8732 9.96332 14.839C10.7135 14.8054 11.2258 14.6881 11.6737 14.5165C12.137 14.3387 12.5298 14.1014 12.9219 13.7155C13.3141 13.3296 13.5543 12.9419 13.7347 12.4853C13.9089 12.0439 14.0284 11.539 14.062 10.7997C14.0962 10.0587 14.1041 9.82252 14.1041 7.93663C14.1041 6.05074 14.0962 5.81402 14.062 5.07358C14.0278 4.33424 13.9089 3.82913 13.7347 3.38797C13.5543 2.93135 13.3135 2.5443 12.9219 2.1578C12.5304 1.7713 12.137 1.53408 11.6743 1.3568C11.2258 1.18513 10.7135 1.06735 9.96388 1.03424C9.21256 1.00058 8.97236 0.992188 7.05876 0.992188C5.14516 0.992188 4.90479 1.00002 4.15307 1.03424Z",
      :fill "currentColor"}]]])

(def linkedin-icon
  [:a
   {:href "https://instagram.com/zhealthstudio" :target "_blank"
    :class
    "w-9 h-9 rounded-full bg-black/40 hover:bg-sky-600/80 flex justify-center items-center transform transition-transform duration-200 hover:scale-110"}
   [:svg
    {:class "w-[1rem] h-[1rem] text-white",
     :viewBox "0 0 13 12",
     :fill "none",
     :xmlns "http://www.w3.org/2000/svg"}
    [:path
     {:d
      "M2.8794 11.5527V3.86835H0.318893V11.5527H2.87967H2.8794ZM1.59968 2.81936C2.4924 2.81936 3.04817 2.2293 3.04817 1.49188C3.03146 0.737661 2.4924 0.164062 1.61666 0.164062C0.74032 0.164062 0.167969 0.737661 0.167969 1.49181C0.167969 2.22923 0.723543 2.8193 1.5829 2.8193H1.59948L1.59968 2.81936ZM4.29668 11.5527H6.85698V7.26187C6.85698 7.03251 6.87369 6.80255 6.94134 6.63873C7.12635 6.17968 7.54764 5.70449 8.25514 5.70449C9.18141 5.70449 9.55217 6.4091 9.55217 7.44222V11.5527H12.1124V7.14672C12.1124 4.78652 10.8494 3.68819 9.16483 3.68819C7.78372 3.68819 7.17715 4.45822 6.84014 4.98267H6.85718V3.86862H4.29681C4.33023 4.5895 4.29661 11.553 4.29661 11.553L4.29668 11.5527Z",
      :fill "currentColor"}]]] )

(def youtube-icon
  [:a
   {:href "https://youtube.com/@zhealthstudio9803" :target "_blank" :aria-label "YouTube"
    :class "w-9 h-9 rounded-full bg-black/40 hover:bg-rose-600/80  flex justify-center items-center transform transition-transform duration-200 hover:scale-110"}
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
    :class "w-9 h-9 rounded-full bg-black/40 hover:bg-orange-600/80 flex justify-center items-center  transform transition-transform duration-200 hover:scale-110"}
   [:svg {:xmlns "http://www.w3.org/2000/svg"
          :viewBox "0 0 24 24"
          :fill "currentColor"
          :class "h-6 w-6 text-white"}
    [:path {:d "M1.5 4.5A2.25 2.25 0 0 1 3.75 2.25h16.5A2.25 2.25 0 0 1 22.5 4.5v15a2.25 2.25 0 0 1-2.25 2.25H3.75A2.25 2.25 0 0 1 1.5 19.5v-15zm2.25-.75a.75.75 0 0 0-.75.75v.384l9 5.625 9-5.625V4.5a.75.75 0 0 0-.75-.75H3.75zm17.25 3.036-7.934 4.958a1.5 1.5 0 0 1-1.632 0L3.75 6.786V19.5a.75.75 0 0 0 .75.75h15a.75.75 0 0 0 .75-.75V6.786z"}]]])

(def phone-icon
  [:a
   {:href "tel:+64211315510"
    :aria-label "Phone"
    :class "w-9 h-9 rounded-full bg-black/40 hover:bg-yellow-400/80 flex justify-center items-center transform transition-transform duration-200 hover:scale-110"}
   [:svg {:xmlns "http://www.w3.org/2000/svg"
          :viewBox "0 0 24 24"
          :fill "currentColor"
          :class "h-6 w-6 text-white"}
    [:path {:d "M2.25 4.5a.75.75 0 0 1 .75-.75h3.246a.75.75 0 0 1 .735.606l.768 3.84a.75.75 0 0 1-.21.705L6.25 10.94a12.005 12.005 0 0 0 6.81 6.81l1.038-1.29a.75.75 0 0 1 .705-.21l3.84.768a.75.75 0 0 1 .606.735V21a.75.75 0 0 1-.75.75H19.5A16.5 16.5 0 0 1 3 5.25V4.5z"}]]])

(def fixed-navbar
  [:nav {:class "fixed top-0 left-0 w-full bg-gray-50 dark:bg-zinc-900 shadow z-50"}
   [:div {:class "max-w-4xl mx-auto px-4 py-3 flex justify-between items-center"}
    [:div {:class "flex text-green-800 dark:text-green-300 space-x-4"}
     [:img {:src "/img/zhealth.svg" :class "h-8"}]
     [:a {:href "#hero" :hx-get "/#hero" :hx-target "#main" :hx-swap "innerHTML" :class "text-xl font-bold hover:text-blue-500 hover:underline"} "Kāpiti Yoga & Pilates"]]

    ;; Desktop nav
    [:div {:class "hidden md:flex text-green-800 dark:text-green-300 space-x-6"}
     [:a {:href "#classes" :hx-get "/#classes" :hx-target "#main" :hx-swap "innerHTML" :class "hover:text-blue-500 hover:underline"} "Classes"]
     [:a {:href "#timetable" :hx-get "/#timetable" :hx-target "#main" :hx-swap "innerHTML" :class "hover:text-blue-500 hover:underline"} "Timetable"]
     [:a {:href "#about" :hx-get "/#about" :hx-target "#main" :hx-swap "innerHTML" :class "hover:text-blue-500 hover:underline"} "About"]]

    ;; Mobile toggle
    [:button {:class "md:hidden p-2 rounded hover:bg-gray-200 dark:hover:bg-zinc-800"
              :aria-label "Toggle menu"
              :_ "on click toggle .hidden on #mobile-menu"}
     [:svg {:xmlns "http://www.w3.org/2000/svg"
            :fill "none"
            :viewBox "0 0 24 24"
            :stroke-width "1.5"
            :stroke "currentColor"
            :class "w-6 h-6 text-green-800 dark:text-green-300"}
      [:path {:stroke-linecap "round"
              :stroke-linejoin "round"
              :d "M3.75 5.25h16.5m-16.5 6h16.5m-16.5 6h16.5"}]]]]

   ;; Mobile menu (moved here!)
   [:div {:id "mobile-menu" :class "md:hidden hidden px-4 pb-4 bg-white shadow"}
    [:ul {:class "space-y-2 text-green-800 dark:text-green-300"}
     [:li [:a {:href "#hero" :hx-get "/#hero" :hx-target "#main" :hx-swap "innerHTML" :class "block hover:text-blue-500" :_ "on click add .hidden to #mobile-menu"} "Home"]]
     [:li [:a {:href "#classes" :hx-get "/#classes" :hx-target "#main" :hx-swap "innerHTML" :class "block hover:text-blue-500" :_ "on click add .hidden to #mobile-menu"} "Classes"]]
     [:li [:a {:href "#timetable" :hx-get "/#timetable" :hx-target "#main" :hx-swap "innerHTML" :class "block hover:text-blue-500" :_ "on click add .hidden to #mobile-menu"} "Timetable"]]
     [:li [:a {:href "#about" :hx-get "/#about" :hx-target "#main" :hx-swap "innerHTML" :class "block hover:text-blue-500" :_ "on click add .hidden to #mobile-menu"} "About"]]]]])

(def sticky-footer
  [:footer {:class "sticky bottom-0 w-full bg-gray-50 dark:bg-zinc-900 text-green-800 dark:text-green-300 shadow-inner py-4 mt-12"}
   [:div {:class "max-w-5xl mx-auto px-4 flex flex-col md:flex-row justify-between items-center space-y-4 md:space-y-0"}
    [:p {:class "text-center md:text-left"} "© 2025 Z Health"]
    [:div {:class "flex justify-center md:justify-end space-x-4 flex-wrap"}
     email-icon
     facebook-icon
     instagram-icon
     youtube-icon
     phone-icon]]])

(def carousel
  [:section {:id "carousel"
             :class "relative w-full overflow-hidden bg-gray-100 py-8 scroll-mt-16"}
   [:div {:class "max-w-3xl mx-auto relative"}

    ;; Carousel container
    [:div {:class "relative w-full h-64 md:h-96 rounded-lg shadow-lg overflow-hidden"
           :_ "
          init
            set my index to 0
            set my slides to <.carousel-slide/> in me
            every 4s
              remove .opacity-100 from my slides
              add .opacity-0 to my slides
              add .opacity-100 to my slides[index]
              remove .opacity-0 from my slides[index]
              set index to (index + 1) mod slides.length
          "}

     ;; Carousel slides
     [:img.carousel-slide1 {:src "/img/mat-kapiti.jpg"
                            :alt "Childs Pose"
                            :class "absolute w-full h-full object-cover transition-opacity duration-1000 opacity-100"}]
     [:img.carousel-slide2 {:src "/img/namaste.jpg"
                            :alt "Lotus"
                            :class "absolute w-full h-full object-cover transition-opacity duration-1000 opacity-0"}]
     [:img.carousel-slide3 {:src "/img/SwissBall.jpg"
                            :alt "Swiss Ball"
                            :class "absolute w-full h-full object-cover transition-opacity duration-1000 opacity-0"}]]

    ;; Optional indicators (dots)
    [:div {:class "absolute bottom-4 left-1/2 transform -translate-x-1/2 flex space-x-2"}
     (for [_ (range 3)]
       [:span {:class "w-3 h-3 bg-white rounded-full opacity-50"}])]]])

(def about
  [:section {:id "about"
             :class "min-h-screen scroll-mt-16 px-4 py-12 bg-gray-50 dark:bg-zinc-900"}
   [:div {:class "max-w-5xl mx-auto"}

    [:h2 {:class "text-3xl md:text-4xl font-bold text-center mb-12 text-green-800 dark:text-green-300"}
     "🌿 About Z Health"]

    [:div {:class "text-bold text-xl text-center text-gray-600 dark:text-gray-400"}
     [:p "Offering high quality Yoga and Pilates classes in the heart of the Kāpiti Coast since 2012"]
     [:p "– and now, online too!"]]

    [:p {:class "mb-4 text-gray-600 dark:text-gray-400"}
     "Zuri is an award-winning teacher with over thirty years of experience in the exercise industry. Zuri’s qualifications include Exercise to Music, Aerobics, Step, Swiss Ball, Yoga, Zumba, Pilates, Yin Yoga, as well as Personal Training and Fitness Assessment. She is also a member of the NZ Register of Exercise Professionals and brings a wealth of knowledge to every practise."]
    ;; Intro block

    [:div {:class "flex flex-col md:flex-row gap-6 mb-12 text-gray-600 dark:text-gray-400"}
     [:div {:class "md:w-1/3 flex justify-center"}
      [:img {:src "img/childs-pose-kapiti.webp"
             :alt "Zuri in child pose"
             :class "rounded-lg shadow-lg max-w-xs"}]]
     [:div {:class "md:w-2/3"}
      [:p {:class "mb-4"}
       "With her background in modern contemporary dance paired with a passion for health and fitness, Zuri has the energy and passion to support you on your wellbeing journey. A mother of three, and now fit and fabulous in her fifties, Zuri has a breadth of understanding on how to balance work, rest and play."]
     [:p {:class "italic text-gray-600 dark:text-gray-400"}
      "“When I was young, I strived to push myself through dance and exercise, but after discovering Yoga in 1998 I began to slow down – finding a softness in my mind and body. While my body has not changed much in the last thirty years, I have learnt that the key to good health is how I feel. Through Pilates, I have found strength in stillness – learning that a deep connection to my body allows me to move with grace, flow and beauty. It is my passion to show everyone this same freedom of movement."]
      ]
     ]
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
       "Zuri is passionate about giving you the space to reconnect with your own internal power and physical strength as she guides you through this journey. Zuri believes that, like her, we can all live a life of balance, pleasure, and strength through learning how to prioritise our wellbeing and value the fluidity of movement."]]
     ]]
   ])

(def hero-section
  [:section {:id "hero"
             :class "min-h-screen bg-no-repeat bg-cover bg-center bg-[url(/img/kapiti-1920.webp)] flex text-center justify-center text-zinc-200 dark:text-zinc-500 scroll-mt-16" }
   [:div {:class "max-w-5xl bg-opacity-50 p-8 rounded"}
    [:h1 {:class "text-2xl md:text-6xl font-bold mb-8 pt-30 justify-center text-white"} "“In " [:em "stillness"] " we find " [:em {:class "animate-fade-in"} "strength"] "“"]
    [:p {:class "text-lg md:text-xl text-center text-white"} "Join our vibrant Kāpiti community — with Yoga, Pilates, and a peaceful space rooted in nature’s calm."]
    [:p {:class "text-lg md:text-xl text-center text-white animate-fade-in"} "since 2012"]]]
  )

(defn class-block [title desc details img-src]
  [:div {:class "flex flex-col md:flex-row items-start md:items-center justify-between gap-6 mb-12"}
   ;; Image Block
   [:div {:class "md:w-1/3 flex justify-center"}
    [:img {:src img-src :alt title :class "rounded-lg shadow-lg w-full max-w-xs"}]]
   ;; Text Block
   [:div {:class "md:w-2/3"}
    [:h3 {:class "text-2xl font-semibold text-green-800 dark:text-green-300 mb-2"} title]
    [:p {:class "text-zinc-700 dark:text-zinc-300 mb-2"} desc]
    (for [line details]
      [:p {:class "text-sm italic text-gray-600 dark:text-gray-400"} line])]
])

(def book-a-class
  [:a {:href "https://bookings.gettimely.com/zhealthstudio/bb/book"
     :target "_blank"
     :rel "noopener noreferrer"
     :class "inline-block self-center md:self-end px-2 py-2 md:mt-0 md:mb-0 mb-8 bg-emerald-200 font-semibold text-lg rounded-xl shadow-md hover:bg-emerald-700 transition-colors duration-300"}
   "Book class here!"])

(def classes-section
  [:section {:id "classes"
             :class "px-4 py-12 scroll-mt-16 bg-gray-50 dark:bg-zinc-900 min-h-screen"}
   [:div {:class "max-w-5xl mx-auto"}

     [:div {:class "flex flex-col md:flex-row md:items-center md:justify-between"}
      [:h2 {:class "w-full md:w-2/3 text-3xl md:text-4xl font-bold text-center mb-8 text-green-800 dark:text-green-300"}
       "Z Health Classes"]
      book-a-class]

    ;; Each class block
    (class-block
     "Yin Yoga"
     "Yin Yoga is “the other half” of yoga. A slow-paced practice with long-held asanas to stimulate the fascia and release deep-seated tension, de-stressing the mind and re-energizing the soul. Suitable for all levels."
     ["Online only!"]
     "img/childs-pose.webp")

    (class-block
     "Yoga Flow"
     "A dynamic yoga practice aiming to rejuvenate the body and free the mind from tension and fatigue. Serves as an introduction to traditional forms of Yoga through physical postures."
     ["Every Saturday 8.45am – 9.45am"
      "Raumati South Memorial Hall, Tennis Court Rd"]
     "img/warrior.webp")

    (class-block
     "Pilates"
     "The Classical Pilates mat practice is a unique sequence of exercises designed by Joseph Pilates, incorporating dynamic moves to tone and strengthen the whole body while improving postural alignment and flexibility."
     ["Every Saturday 10am – 10.45am"
      "Raumati South Memorial Hall, Tennis Court Rd"]
     "img/pilates.webp")

    (class-block
     "Yogilates"
     "Ideal for those new to Yoga and/or Pilates. Introduces basic Pilates principles and incorporates Yoga postures and breath to reconnect the mind, body, and soul."
     ["Please bring a mat and/or blanket – blocks and bolsters are provided!"
      "Every Tuesday & Thursday 9.30am – 10.30am"
      "Paraparaumu Memorial Hall, Aorangi Road, Paraparaumu"]
     "img/childs-pose-kapiti.webp")

    (class-block
     "Swiss Ball"
     "Enhances core strength, joint, and spine stability. The constant adjustments required on the ball help in tuning into internal sensations, making it suitable for those returning to exercise from injury or as part of rehabilitation."
     ["Private bookings available on request!"]
     "img/swiss-ball.webp")

    (class-block
     "Personal Yoga/Pilates Practice"
     "Available online (via Zoom) or in-person at a private studio in Raumati South, Kāpiti Coast."
     ["30mins / 40mins / 1hr sessions – appointments on request"]
     "img/yoga-teacher-of-year.webp")

    (class-block
     "Guided Meditation"
     "Available online (via Zoom) or in-person at a private studio in Raumati South, Kāpiti Coast."
     ["30mins / 40mins / 1hr sessions – appointments on request"]
     "img/fish-zen-sq.webp")
    ]])

(def timetable
  [:section {:id "timetable"
             :class "px-4 py-12 scroll-mt-16 bg-gray-50 dark:bg-zinc-900 min-h-screen bg-no-repeat bg-contain bg-center bg-[url(/img/fish-zen.webp)]"}
   [:div {:class "max-w-5xl mx-auto"}

   [:div {:class "flex flex-col md:flex-row md:items-center md:justify-between mb-8"}
    [:h2 {:class "text-3xl md:text-4xl font-bold text-center  text-green-800 dark:text-green-300"}
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
                         ["Yogilates" "Paraparaumu Memorial Hall (+ online)"],
                         ["Yogilates" "Paraparaumu Memorial Hall (+ online)"],
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
           {"Monday" [["6pm" "Yin Yoga" "(online)"]]
            "Tuesday" [["9.30am" "Yogilates" "Paraparaumu Memorial Hall (+ online)"]]
            "Thursday" [["9.30am" "Yogilates" "Paraparaumu Memorial Hall (+ online)"]]
            "Saturday" [["8.45am" "Yoga Flow" "Raumati South Memorial Hall"]
                        ["10am" "Pilates" "Raumati South Memorial Hall"]]}]
       [:div {:class "bg-white dark:bg-zinc-800 rounded shadow p-4"}
        [:div {:class "text-green-900 dark:text-green-100 font-bold text-xl mb-2"} day]
        (for [[time class location] entries]
          [:div {:class "mb-3"}
           [:div {:class "text-sm text-green-800 dark:text-green-300 font-semibold"} time]
           [:div {:class "text-base font-medium dark:text-white"} class]
           [:div {:class "text-sm italic text-gray-600 dark:text-gray-400"} location]])])]
    ]])

(defn home [ctx]
  (ui/base
   ctx
   [:body {:class "relative min-h-screen font-sans bg-zinc-50 dark:bg-zinc-900 "}
    fixed-navbar
    ;; Page content area with top padding which get replaced by htmx
    [:main {:id "main" :class "pt-16"}
     hero-section
     classes-section
     timetable
     about
     sticky-footer
     ]
    ]
   )
  )

(def module
  {:routes [["/" {:get home}]]})
