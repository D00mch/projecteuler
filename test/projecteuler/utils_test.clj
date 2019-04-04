(ns projecteuler.utils-test
  (:require [projecteuler.utils :as utils]
            [clojure.test :refer :all]))

(defn- rand-ints [n]
  (take n (repeatedly #(rand-int n))))

(deftest test-lazy-quick-sort
  (testing "same result as default sort"
    (let [ints (rand-ints 30)]
      (is (= (utils/lz-qsort ints) (sort ints)))
      (is (= (utils/lz-qsort > ints) (sort > ints))))))
