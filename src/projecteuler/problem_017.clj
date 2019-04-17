(ns projecteuler.problem-017
  (:require [clojure.string :as str]))

(def nums
  {1 "one" 2 "two" 3 "three" 4 "four" 5 "five"
   6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten"
   11	"eleven" 12	"twelve" 13	"thirteen" 14	"fourteen"
   15	"fifteen" 20 "twenty" 30 "thirty" 40 "forty"
   50	"fifty" 100 "one hundred" 1000 "one thousand"})

(defn- num-name [n]
  (let [table-name (nums n)]
    (-> (cond table-name table-name

              (< 15 n 20)
              (str (num-name (rem n 10)) "teen")

              (< 20 n 100)
              (if (= (rem n 10) 0)
                (str (num-name (quot n 10)) "ty")
                (str (num-name (* (quot n 10) 10)) "-" (num-name (rem n 10))))

              (< 100 n 1000)
              (let [start (str (num-name (quot n 100)) " hundred")]
                (if (= (rem n 100) 0)
                  start
                  (str start " and " (num-name (rem n 100))))))

        (str/replace #"tt" "t"))))

(defn solution
  "If all the numbers from 1 to 1000 (one thousand) inclusive
   were written out in words, how many letters would be used?"
  []
  (let [nums-written (->> (range 1 1001) (map num-name) (reduce str))]
    ;; can be rewritten with no text for optimization
    ;; if num-name returns nums, not strings
    (-> (str/replace nums-written #"( |-)" "")
        count)))
