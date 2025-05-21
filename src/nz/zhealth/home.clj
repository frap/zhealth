(ns nz.zhealth.home
  (:require [clj-http.client :as http]
            [com.biffweb :as biff]
            [nz.zhealth.middleware :as mid]
            [nz.zhealth.ui :as ui]
            [nz.zhealth.settings :as settings]
            [rum.core :as rum]
            [xtdb.api :as xt]))


(defn a [to text]
  [:a.font-bold.text-yellow-300.hover:text-pink-600 {:href to} text])

(defn home [sys]
  (ui/page
   {}
   nil
   [:div
    [:.h-1] ;; white spacing
    [:p.text-center.text-lg.md:text-xl.lg:text-2xl.mt-4.text-gray-400
     "About Z Health Studio Team."]
    [:p.text-black:text-left
     "Offering high quality classes specialising in Yoga, Pilates, Swiss Ball, and more in the heart of the Kāpiti Coast since 2012."]
    [:img.object-contain.h-48.w-48 {:src "https://669156.smushcdn.com/1286378/wp-content/uploads/2022/08/Copy-of-Untitled.png?lossy=1&strip=1&webp=1"}]
    [:p.leading-loose "Zuri is the studio owner and award-winning teacher with over 30 years of experience.  This includes qualifications in Exercise to Music, Aerobics, Step, Swiss Ball, Yoga, Zumba, Pilates, Yin Yoga, as well as Personal Training & Fitness Assessment.

With her background in modern contemporary dance and a passion for health and fitness she has the energy and experience to support you on your well-being journey.

A mother of three grown-up children, and now fit and fabulous in her 50’s she has a great understanding and empathy of juggling work, rest, and play in the modern world."]

    ]
   [:footer.mt-auto "footer is here"]

   )
  )





(def module
  {:routes [["/" {:get home}]]})
