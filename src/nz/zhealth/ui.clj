(ns nz.zhealth.ui
  (:require [cheshire.core :as cheshire]
            [clojure.java.io :as io]
            [nz.zhealth.settings :as settings]
            [com.biffweb :as biff]
            [ring.middleware.anti-forgery :as csrf]
            [ring.util.response :as ring-response]
            [rum.core :as rum]))

(defn static-path [path]
  (if-some [last-modified (some-> (io/resource (str "public" path))
                                  ring-response/resource-data
                                  :last-modified
                                  (.getTime))]
    (str path "?t=" last-modified)
    path))

(def default-meta
  {:base/title "Z Health"
   :base/lang "en-NZ"
   :base/icon "/favicon.ico"
   :base/url "https://zhealth.nz"
   :base/description "Z Health offers Yoga, Pilates, and Wellness classes in the heart of Kāpiti. Join us for strength, stillness, and community."
   :base/image "/img/zhealth.png"})

(defn local-business-jsonld []
  (let [{:base/keys [title url image]} default-meta]
    [:script {:type "application/ld+json"}
     (cheshire/generate-string
      {"@context" "https://schema.org"
       "@type" "YogaandPilatesBusiness"
       "@id" url
       "name" title
       "image" (str url image)
       "url" url
       "telephone" "+64-21-131-1550"
       "address" {"@type" "PostalAddress"
                  "addressLocality" "Kāpiti"
                  "addressRegion" "Wellington"
                  "postalCode" "5032"
                  "addressCountry" "NZ"}
       "openingHours" ["Mo-Fr 07:00-10:00" "Sa 08:45-11:00"]
       "priceRange"  "<$-$$>"
       "acceptsReservations" "True"})]))


(defn base [{:keys [::recaptcha] :as ctx} & body]
  (apply
   biff/base-html
   (-> ctx
       ;; Remove default keys to avoid duplication
       (merge default-meta)
       ;; (dissoc :base/title :base/description :base/image :base/url :base/lang)
       ;; Add SEO meta only to head
       (update :base/head (fn [head]
                            (fnil into []) ;; if nil make a vector
                            (concat
                             [[:link {:rel "stylesheet" :href (static-path "/css/main.css")}]
                              [:script {:src (static-path "/js/main.js")}]
                              [:script {:src "https://unpkg.com/htmx.org@2.0.4"}]
                              [:script {:src "https://unpkg.com/htmx-ext-ws@2.0.1/ws.js"}]
                              [:script {:src "https://unpkg.com/hyperscript.org@0.9.13"}]
                              [:link {:href "/apple-touch-icon.png", :sizes "180x180", :rel "apple-touch-icon"}]
                              [:link {:href "/favicon16x16.png", :sizes "16x16", :type "image/png", :rel "icon"}]
                              [:link {:href "/favicon-32x32.png", :sizes "32x32", :type "image/png", :rel "icon"}]
                              [:link {:href "/site.webmanifest", :rel "manifest"}]
                              [:link {:color "#5bbad5", :href "/safari-pinned-tab.svg", :rel "mask-icon"}]
                              [:meta {:content "#da532c", :name "msapplication-TileColor"}]
                              [:meta {:content "#0d9488", :name "theme-color"}]
                              (local-business-jsonld)
                              (when recaptcha
                                [:script {:src "https://www.google.com/recaptcha/api.js"
                                          :async "async" :defer "defer"}])]
                             head))))
   body))

  (defn page [ctx & body]
    (base
     ctx
     [:.bg-green-50.flex.flex-col.flex-grow
      [:.p-3.mx-auto.max-w-screen-sm.w-full
       (when (bound? #'csrf/*anti-forgery-token*)
         {:hx-headers (cheshire/generate-string
                       {:x-csrf-token csrf/*anti-forgery-token*})})
       body]]
     [:.flex-grow]
     [:.flex-grow]))

(defn on-error [{:keys [status ex] :as ctx}]
  {:status status
   :headers {"content-type" "text/html"}
   :body (rum/render-static-markup
          (page
           ctx
           [:h1.text-lg.font-bold
            (if (= status 404)
              "Page not found."
              "Something went wrong.")]))})
