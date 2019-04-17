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

(deftest test-sum-digits
  (testing ""
    (is (= -6 (utils/sum-digs -123)))
    (for [n (range 100)
          :let [num (rand-int 999999)]]
      (is (= (->> (str num) (map #(Character/getNumericValue %)) (reduce +))
             (utils/sum-digs num))))))
