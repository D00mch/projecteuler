(ns projecteuler.pyramids
  (:require [clojure.string :as str]))

;; TODO: optimize with java array

(defn- next-el-in-matrix [m i j]
  (let [il (count m)
        jl (count (nth m i))]
    (cond (and (>= i (dec il)) (>= j (dec jl))) nil
          (>= j jl)                             [(inc i) 0]
          :else                                 [i (inc j)])))

(defn- max-incremented-sum
  "Dynamic approach. Assume we can go to i from j and k.
   That's mean, that incremented sum of i = i + (max j' k'),
   where j' and k' are incremented sum of j and k.
   returns 0 for illegal input, like (max-incremented-sum m [-1 -1])"
  [matrix [i j]]
  (letfn [(get [i j] (get-in matrix [i j] 0))]
    (+ (get i j)
       (max (get (dec i) j)
            (get (dec i) (dec j))))))

(defn rebuild-matrix-to-inc-sum
  "  1          1
    2 3  -->   3 4
   4 4 1      7 8 4"
  [matrix]
  (loop [m matrix, [i j :as pos] [0 0]]
    (if pos
      (recur (assoc-in m [i j] (max-incremented-sum m pos))
             (next-el-in-matrix m i j))
      m)))

(defn pyramid->matrix
  "convert string pyramid representation to vector of vectors"
  [raw]
  (let [splited  (str/split raw #"\n")
        str->vec (fn [s] (->> (str/split s #" ")
                              (filter (complement empty?))
                              (mapv #(Integer/parseInt %))))]
    (mapv str->vec splited)))
