(ns projecteuler.utils)

(defn- sort-parts [comp work]
  (-> (loop [[part & parts] work]
        (if-let [[pivot & xs] (seq part)]
          (let [smaller? #(comp % pivot)]
            (recur (list*
                    (filter smaller? xs)
                    pivot
                    (remove smaller? xs)
                    parts)))
          (when-let [[x & parts] parts]
            (cons x (sort-parts comp parts)))))
      lazy-seq))

(defn lz-qsort
  "lazy qsort implementation"
  ([col]
   (lz-qsort < col))
  ([comp col]
   (sort-parts comp (list col))))

(defn prime? [n]
  (loop [end (Math/floor (Math/sqrt n))]
    (cond (< end 2)           true
          (= 0.0 (rem n end)) false
          :else               (recur (dec end)))))

(def primes
  (cons 2 (->> (iterate (partial + 2) 3)
               (filter prime?)
               lazy-seq)))
