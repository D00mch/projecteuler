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

(defn prime?
  "Miller-Rabin test"
  [accuracy n]
  (.isProbablePrime (BigInteger/valueOf n) accuracy))

(defn primes
  "use :accuracy to specify Miller-Rabin test risk"
  [& {:keys [accuracy] :or {accuracy 7}}]
  (cons 2 (->> (iterate (partial + 2) 3)
               (filter (partial prime? accuracy))
               lazy-seq)))

(defn pow [n m]
  (reduce *' (repeat m n)))

(defn sum-digs [n]
  (loop [i 0, s n]
    (if (= s 0)
      i
      (recur (+ i (rem s 10)) (quot s 10)))))
