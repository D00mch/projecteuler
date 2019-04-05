(ns projecteuler.problem-003
  (:require [projecteuler.utils :as utils]))

(defn solution
  ;; largest prime factor of the number 600851475143
  []
  (loop [n       600851475143
         factors (rest (utils/primes))]
    (let [prime  (first factors)]
      (cond (= prime n)         n
            (= 0 (rem n prime)) (recur (/ n prime) (rest factors))
            :else               (recur n (rest factors))))))
