(ns projecteuler.problem-006)

(defn solution
  "the difference between the sum of the squares of the
   first one hundred natural numbers and the square of the sum"
  []
  (let [range100 (range 1 101)
        sum (reduce + range100)
        sqr-of-sum (* sum sum)
        sum-of-sqr (reduce + 0 (map #(* % %) range100))]
    (- sqr-of-sum sum-of-sqr)))
