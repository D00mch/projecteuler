(ns projecteuler.problem-005)

(defn- divisible? [n dividers]
  (every? #(= 0 (rem n %)) dividers))

(defn solution
  "the smallest positive number that is evenly divisible by
   all of the numbers from 1 to 20"
  []
  (let [range20 (range 1 21)]
    (->> (iterate (partial + 20) 2520)
         (filter #(divisible? % range20))
         first)))
