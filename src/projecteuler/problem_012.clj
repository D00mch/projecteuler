(ns projecteuler.problem-012)

(def ^:private triangle-nums
  (->> (iterate inc 1) (reductions +)))

(defn- divisors-count [n]
  (* 2 (count (filter #(= 0 (rem n %))
                      (range 1 (Math/sqrt n))))))

(defn- triangle-num-with-over-n-divisors [n]
  (->> triangle-nums
       (drop-while #(< (divisors-count %) n))
       first))

(defn solution
  "the value of the first triangle number to have over five hundred divisors"
  []
  (triangle-num-with-over-n-divisors 500))
