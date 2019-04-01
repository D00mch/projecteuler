(ns projecteuler.problem-003)

(defn- prime? [n]
  (loop [end (Math/floor (Math/sqrt n))]
    (cond (< end 4)           true
          (= 0.0 (rem n end)) false
          :else               (recur (dec end)))))

(def ^:private primes
  (concat [1 2]
          (->> (iterate (partial + 2) 3)
               (filter prime?)
               lazy-seq)))

(defn solution
  ;; largest prime factor of the number 600851475143
  []
  (loop [n       600851475143
         factors (rest primes)]
    (let [prime (first factors)]
      (cond (= prime n)         n
            (= 0 (rem n prime)) (recur (/ n prime)
                                       (rest factors))
            :else               (recur n
                                       (rest factors))))))
