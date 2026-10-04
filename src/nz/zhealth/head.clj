(ns nz.zhealth.head
  (:require [cheshire.core :as cheshire]
            [dev.onionpancakes.chassis.core :as c]))

(def site
  {:title       "Z Health"
   :url         "https://zhealth.nz"
   :description "Z Health offers Yoga, Pilates, and Wellness classes in the heart of Kāpiti. Join us for strength, stillness, and community."
   :image       "/img/zhealth.png"})

(defn local-business-jsonld []
  (let [{:keys [title url image]} site]
    [:script {:type "application/ld+json"}
     (c/raw
      (cheshire/generate-string
       {"@context"            "https://schema.org"
        "@type"               "SportsActivityLocation"
        "@id"                 url
        "name"                title
        "image"               (str url image)
        "url"                 url
        "telephone"           "+64-21-131-1550"
        "address"             {"@type"           "PostalAddress"
                               "addressLocality" "Kāpiti"
                               "addressRegion"   "Wellington"
                               "postalCode"      "5032"
                               "addressCountry"  "NZ"}
        "openingHours"        ["Mo-Fr 07:00-10:00" "Sa 08:45-11:00"]
        "priceRange"          "$"
        "acceptsReservations" true}))]))

(defn head [_req]
  (let [{:keys [title url description image]} site]
    [[:meta {:name "description" :content description}]
     [:meta {:property "og:title" :content title}]
     [:meta {:property "og:description" :content description}]
     [:meta {:property "og:url" :content url}]
     [:meta {:property "og:image" :content (str url image)}]
     [:meta {:property "og:locale" :content "en_NZ"}]
     [:link {:rel "stylesheet" :href "/css/main.css"}]
     [:link {:rel "icon" :href "/favicon.ico"}]
     [:link {:rel "icon" :type "image/png" :sizes "16x16" :href "/favicon-16x16.png"}]
     [:link {:rel "icon" :type "image/png" :sizes "32x32" :href "/favicon-32x32.png"}]
     [:link {:rel "apple-touch-icon" :sizes "180x180" :href "/apple-touch-icon.png"}]
     [:link {:rel "manifest" :href "/site.webmanifest"}]
     [:meta {:name "theme-color" :content "#0d9488"}]
     (local-business-jsonld)]))
