(ns projecteuler.core-test
  (:require [clojure.test :refer :all]
            [projecteuler.problem-002 :as problem-002]))

(deftest all-the-problems
  (testing "test all the problems"
    (is (= 4613732 (problem-002/solution)))
    ))




