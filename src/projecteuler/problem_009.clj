(ns projecteuler.problem-009)

(defn- pythagorean? [a b c]
  (= (+ (* a a) (* b b)) (* c c)))

(defn solution
  "There exists exactly one Pythagorean triplet for
  which a + b + c = 1000. Find the product abc."
  []
  (first (for [a (range 1 1000)
               b (range a (- 1000 a))
               :let  [c (- 1000 a b)]
               :when (and (> c b) (pythagorean? a b c))]
           (* a b c))))
