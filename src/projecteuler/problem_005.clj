(ns projecteuler.problem-005)

(defn- gcd [n k]
  (loop [a n, b k]
    (if (zero? b)
      a
      (recur b (mod a b)))))

(defn- lcm
  "least common multiple; 4 5 -> 20"
  [^long n ^long k]
  (/ (Math/abs (* n k)) (gcd n k)))

(defn solution
  "the smallest positive number that is evenly divisible by
   all of the numbers from 1 to 20"
  []
  (reduce lcm 1 (range 1 21)))
