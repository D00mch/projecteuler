(ns projecteuler.problem-014)

(defn- collatz-f [n]
  (if (even? n) (/ n 2) (-> (* 3 n) (+ 1))))

(defn- collatz-count [num]
  (loop [n num, count 0]
    (if (= n 1)
      count
      (recur (collatz-f n) (inc count)))))

(defn solution
  "Which starting number, under one million, produces the longest Collatz chain?"
  []
  (->> (range 1 1000000 2) ;; it's definitely not an even number, right?
       (pmap #(vector % (collatz-count %)))
       (reduce #(if (> (second %1) (second %2)) %1 %2))
       first))
