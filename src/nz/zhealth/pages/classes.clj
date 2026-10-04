(ns nz.zhealth.pages.classes
  (:require
   [nz.zhealth.layout :as layout]
   [nz.zhealth.components :as c]))

(defn page [req]
  (layout/page-layout
   req
   c/classes-section))
