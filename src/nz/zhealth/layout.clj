(ns nz.zhealth.layout
  (:require [hyper.core :as h]
            [nz.zhealth.components :as c]))

(defn navbar [req]
  [:nav
   {:class "fixed inset-x-0 top-0 z-50 h-16 bg-gray-50/95 dark:bg-zinc-900/95 shadow"}

   [:div
    {:class "h-full max-w-5xl mx-auto px-4 flex items-center justify-between"}

    [:a
     (merge
      (h/navigate :home)
      {:class "flex items-center gap-3 text-green-800 dark:text-green-300"})
     [:img {:src "/img/zhealth.svg"
            :class "h-8"
            :alt "Z Health"}]
     [:span {:class "font-bold"}
      "Yoga & Pilates with Zuri"]]

    [:div
     {:class "hidden md:flex gap-6"}

     [:a (merge
          (h/navigate :why)
          {:class "hover:underline"})
      "Why ZHealth?"]

     [:a (merge
          (h/navigate :timetable)
          {:class "hover:underline"})
      "Timetable"]

     [:a (merge
          (h/navigate :classes)
          {:class "hover:underline"})
      "Classes"]

     [:a (merge
          (h/navigate :about)
          {:class "hover:underline"})
      "About Zuri"]]]])

(defn page-layout [req content]
  [:div
   {:class "min-h-dvh font-sans bg-zinc-50 dark:bg-zinc-900"}

   (navbar req)

   [:main {:class "pt-16"}
    content]

   (c/site-footer)])
