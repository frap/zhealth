(require '["https://esm.sh/preact@10.19.2" :as react])
(require '["https://esm.sh/preact@10.19.2/hooks" :as hooks])

(defn Counter []
  (let [[counter setCounter] (hooks/useState 0)]
    #jsx [:<>
          [:div.text-lg.font-medium.mb-2 "Counter " counter]
          [:div.flex.space-x-2
           [:button {:class "bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition"
                     :onClick #(setCounter (inc counter))} "+"]
           [:button {:class "bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition"
                     :onClick #(setCounter (dec counter))} "-"]]]
    )
  )

(defonce el (js/document.getElementById "cljs"))

(react/render #jsx [Counter] el)
