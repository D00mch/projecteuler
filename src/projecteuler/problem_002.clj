(ns projecteuler.problem-002)

;; Even Fibonacci numbers with vals < 4.000.000

(def lz-fib
  (lazy-cat [0 1] (map + lz-fib (rest lz-fib))))

(defn solution []
  (->> lz-fib
       (filter even?)
       (take-while #(< % 4000000))
       (reduce +)))
