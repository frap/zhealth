(ns build
  (:require [clojure.tools.build.api :as b]))

(def class-dir "target/classes")
(def uber-file "target/zhealth.jar")
(def basis (delay (b/create-basis {:project "deps.edn"})))

(defn clean [_]
  (b/delete {:path class-dir})
  (b/delete {:path uber-file}))

(defn uber
  "Build target/zhealth.jar. Run `bb css` first so the compiled CSS is bundled."
  [_]
  (clean nil)
  (b/copy-dir {:src-dirs   ["src" "resources" "target/resources"]
               :target-dir class-dir})
  (b/compile-clj {:basis      @basis
                  :ns-compile '[nz.zhealth.app]
                  :class-dir  class-dir})
  (b/uber {:class-dir class-dir
           :uber-file uber-file
           :basis     @basis
           :main      'nz.zhealth.app})
  (println "Built" uber-file))
