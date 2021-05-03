(ns zuri.server-test
  (:require [clojure.test :refer [deftest is testing]]
            [zuri.server :as SUT]))

(deftest handler-200
  (testing "Proper 200 status returned"
    (is (= 200 (:status (SUT/handler {}))))))
