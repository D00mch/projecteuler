(ns projecteuler.core
  (:gen-class))

(defn- run-problem [num]
  (let [filename (format "projecteuler.problem-%03d" num)]
    (use (symbol filename))
    (eval (list (symbol "solution")))))

(defn -main
  "pass problem number like 'lein run 2'"
  [& args]
  (if (= (count args) 1)
    (let [num (Integer/parseInt (first args))]
      (prn "problem number is" num)
      (try
        (prn (time (run-problem num)))
        (catch java.io.FileNotFoundException e
          (prn "I didn't solve the problem with num " num))))
    (prn "your args is" args ". Pass 1 num please")))
