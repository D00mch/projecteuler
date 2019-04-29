(ns projecteuler.core-test
  (:require [clojure.test :refer :all]))

(defn tst [num expected ]
  (do (printf "problem-%03d: " num)
      (let [filename  (format "projecteuler.problem-%03d" num)]
        (require (symbol filename))
        (->> (read-string (str "(" filename "/solution)"))
             eval
             time
             (= expected)
             is))))

(deftest all-the-problems
  (testing "test all the problems"
    (tst 2 4613732)
    (tst 3 6857)
    (tst 4 906609)
    (tst 5 232792560)
    (tst 6 25164150)
    (tst 7 104743)
    (tst 8 23514624000)
    (tst 9 31875000)
    (tst 10 142913828922)
    (tst 11 70600674)
    (tst 12 76576500)
    (tst 13 5537376230)
    (tst 14 837799)
    (tst 15 137846528820N)
    (tst 16 1366)
    (tst 17 21124)
    (tst 18 1074)
    (tst 67 7273)))
