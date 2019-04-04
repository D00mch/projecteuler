(ns projecteuler.problem-009)

(defn- uniq-triples
  "returs seq of vectors with [a < b < c]"
  [end]
  (mapcat (fn [a]
            (mapcat (fn [b]
                      (map (fn [c] [a b c])
                           (range (inc b) end)))
                    (range (inc a) end)))
          (range 1 end)))

(defn- pythagorean? [[a b c]]
  {:pre [(< a b c)]}
  (= (Math/pow c 2)
     (+ (Math/pow a 2) (Math/pow b 2))))

(def ^:private pythagoreans
  (->> (uniq-triples 500)
       (filter pythagorean?)
       lazy-seq))

(defn solution
  "There exists exactly one Pythagorean triplet for
  which a + b + c = 1000. Find the product abc."
  []
  (->> (filter (fn [[a b c]] (= 1000 (+ a b c)))  pythagoreans)
       first
       (apply *)))
