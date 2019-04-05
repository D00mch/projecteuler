(ns projecteuler.problem-007
  (:require [projecteuler.utils :as utils]))

(defn solution
  "the 10 001st prime number"
  []
  (nth (utils/primes) 10000))
