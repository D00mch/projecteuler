(ns projecteuler.problem-010
  (:require [projecteuler.utils :as utils]))

(defn solution
  "Find the sum of all the primes below two million."
  []
  (->> (utils/primes :accuracy 8)
       (take-while #(< % 2000000))
       (reduce + 0)))
