(ns projecteuler.problem-015)

(defn- fact [n]
  (->> (range 1 (inc n)) (reduce *')))

(defn- combinations [n r]
  (/ (fact n)
     (*' (fact r) (fact (- n r)))))

(defn- count-routes [grid]
  (combinations (* grid 2) grid))

(defn solution
  "Starting in the top left corner of a 20×20 grid,
  and only being able to move to the right and down,
  there are exactly *?* routes to the bottom right corner."
  []
  (count-routes 20N))
