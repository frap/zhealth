(ns nz.zhealth.pages.home
  (:require
   [nz.zhealth.layout :as layout]
   [nz.zhealth.components :as c]))

(defn page [req]
  (layout/page-layout
   req
   [:div
    c/hero-section
    c/carousel]))
