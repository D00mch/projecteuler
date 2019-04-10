(ns projecteuler.core-test
  (:require [clojure.test :refer :all]
            [projecteuler.problem-002 :as problem-002]
            [projecteuler.problem-003 :as problem-003]
            [projecteuler.problem-004 :as problem-004]
            [projecteuler.problem-005 :as problem-005]
            [projecteuler.problem-006 :as problem-006]
            [projecteuler.problem-007 :as problem-007]
            [projecteuler.problem-008 :as problem-008]
            [projecteuler.problem-009 :as problem-009]
            [projecteuler.problem-010 :as problem-010]
            [projecteuler.problem-011 :as problem-011]
            [projecteuler.problem-012 :as problem-012]))

(deftest all-the-problems
  (testing "test all the problems"
    (is (= 4613732 (problem-002/solution)))
    (is (= 6857 (problem-003/solution)))
    (is (= 906609 (problem-004/solution)))
    (is (= 232792560 (problem-005/solution)))
    (is (= 25164150 (problem-006/solution)))
    (is (= 104743 (problem-007/solution)))
    (is (= 23514624000 (problem-008/solution)))
    (is (= 31875000 (problem-009/solution)))
    (is (= 142913828922 (problem-010/solution)))
    (is (= 70600674 (problem-011/solution)))
    (is (= 76576500 (problem-012/solution)))
    ))

