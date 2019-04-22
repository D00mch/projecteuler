(ns projecteuler.problem-067
  (:require [projecteuler.pyramids :as pyr]))

(def ^:private pyramid-path "resources/p067_triangle.txt")

(defn solution
  "Find the maximum total from top to bottom of the triangle"
  []
  (->> (slurp pyramid-path)
       (pyr/pyramid->matrix)
       (pyr/rebuild-matrix-to-inc-sum)
       last
       (reduce max)))
