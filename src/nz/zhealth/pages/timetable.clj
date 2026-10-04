(ns nz.zhealth.pages.timetable
  (:require
   [nz.zhealth.layout :as layout]
   [nz.zhealth.components :as c]))

(defn page [req]
  (layout/page-layout
   req
   c/timetable-section))
