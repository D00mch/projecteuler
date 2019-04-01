(ns projecteuler.core
  (:gen-class))

(defn- load-problem [num]
  (let [filename (format "projecteuler.problem-%03d" num)]
    (use (symbol filename))))

(defn- run-problem [] (eval (list (symbol "solution"))))

(defn- parse-int [number-string]
  (try (Integer/parseInt number-string)
       (catch Exception e nil)))

(defn -main
  "pass problem number like 'lein run 2'"
  [& args]
  (if-let [num (and (= (count args) 1) (parse-int (first args)))]
    (try
      (load-problem num)
      (prn "problem number is" num ", result: " (time (run-problem)))
      (catch java.io.FileNotFoundException e
        (prn "I didn't solve the problem with num " num)))

    (prn "your args is" args ". Pass 1 num please")))
