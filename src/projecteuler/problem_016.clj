(ns projecteuler.problem-016
  (:require [projecteuler.utils :as utils]))

(defn solution
  "What is the sum of the digits of the number 2^1000?"
  []
  (-> (utils/pow 2 1000) utils/sum-digs))
