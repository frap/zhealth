(ns nz.zhealth.pages.why
  (:require
   [nz.zhealth.layout :as layout]
   [nz.zhealth.components :as c]))

(defn page [req]
  (layout/page-layout
   req
   c/why-zhealth))
