(ns user
  (:require [hyper.core :as h]
            [nz.zhealth.app :as app]))

(defonce server (atom nil))

(defn go []
  (when-not @server
    (reset! server (h/start! app/handler {:port 3000})))
  :started)

(defn halt []
  (when-let [s @server]
    (h/stop! s)
    (reset! server nil))
  :stopped)

(comment
  (go)
  (halt))
