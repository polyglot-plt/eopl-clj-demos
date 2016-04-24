(ns ch1.s-1-2-4.sec_1_2_4_test
  (:require [clojure.test :refer :all]
            [ch1.s-1-2-4.lambda-occurs-free :refer :all]))

(deftest sec-124
  (testing "occurs-free? --> Sec 1.2.4"

    (let [e1 'x
          e2 'y

          e3 '(fn [x] (x y))

          e4 '(fn [y] (x y))

          e5 '((fn [x] x) (x y))
          e6 '(fn [y] (fn [z] (x (y z))))

          res (map #(occurs-free? 'x %) [e1 e2 e3 e4 e5 e6])]
      (is (= res [true false false true true true])))))
