(ns nz.zhealth.pages.about
  (:require
   [nz.zhealth.layout :as layout]
   [nz.zhealth.components :as c]))

(defn page [req]
  (layout/page-layout
   req
   (c/about)))
