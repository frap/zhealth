(ns zuri.server
  (:gen-class)
  (:require [org.httpkit.server :as server]))

(defn optional-keys [& {:keys [port timeout]
                        :or   {port 8000 timeout 100} }]
  (str "Port: " port ", timeout " timeout ))


(defn handler
  "A function that handles all requests from the server.
  Arguments: `req` is a ring request hash-map
  Return: ring response hash-map including :status :headers and :body"
  [req]
  {:status  200
  :headers {}
  :body    "Hola Zuri!"})

(defn create-server
  "A ring-based server listening to all http requests
  port is an Integer greater than 128"
  [port]
  (server/run-server handler {:port port}))

(defonce ^:private api-server (atom nil) )

(defn stop-server
  "Gracefully shutdown the server, waiting 100ms "
  []
  (when-not (nil? @api-server)
    ;; graceful shutdown: wait 100ms for existing requests to be finished
    ;; :timeout is optional, when no timeout, stop immediately
    (@api-server :timeout 100)
    (reset! api-server nil)))


(defn -main
  "Start a httpkit server with a specific port
  #' enables hot-reload of the handler function and anything that code calls"
  [& {:keys [ip port]
      :or   {ip   "0.0.0.0"
             port 9999}}]
  (println "INFO: Starting httpkit server on port:" port)
  (reset! api-server (server/run-server #'handler {:port port})))
