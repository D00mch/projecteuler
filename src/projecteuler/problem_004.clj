(ns projecteuler.problem-004
  (:require [projecteuler.utils :as utils]))

(defn- palindrome? [n]
  (let [s (str n)] (= s (clojure.string/reverse s))))

(defn- lz-uniq-pairs-reversed
  "for [8 10] result would be: ([10 10] [10 9] [10 8] [9 9] [9 8] [8 8])"
  [start end]
  (-> (mapcat (fn [x]
                (map #(vector x %)
                     (range x (dec start) -1)))
              (range end (dec start) -1))
      lazy-seq))

(defn- find-max-palindrom
  ;; largest palindrome made from the product of two numbers less than max-num
  [max-num]
  (let [palindroms (->> (lz-uniq-pairs-reversed 1 max-num)
                        (map #(* (first %) (second %)))
                        (filter palindrome?))]
    (->> (take (quot max-num 50) palindroms) ;; taking only top (1/50) palindroms
         (utils/lz-qsort >)                  ;; to lazy sort only a little range
         first)))

(defn solution [] (find-max-palindrom 999))
