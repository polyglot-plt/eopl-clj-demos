;;
;; Author José Albert Cruz Almaguer <jalbertcruz@gmail.com>
;; Copyright 2016 by José Albert Cruz Almaguer.
;;
;; This program is licensed to you under the terms of version 3 of the
;; GNU Affero General Public License. This program is distributed WITHOUT
;; ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
;; MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
;; AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
;;

(ns ch2.s-4.tool-for-dtypes-test
  (:require [clojure.test :refer :all]
            [ch2.s-4.tool-for-dtypes :refer :all]))

(deftest  ^:sec-24 sec-24
  (testing "occurs-free? --> Sec 2.4"

    (let [e1 (var-exp 'x)
          e2 (var-exp 'y)

           ;(lambda-exp 'x (app-exp 'x 'y))
          e3 (lambda-exp 'x (app-exp (var-exp 'x) (var-exp 'y)))

           ;e4 '(fn [y] (x y))
          e4 (lambda-exp 'y (app-exp (var-exp 'x) (var-exp 'y)))

           ;e5 '((fn [x] x) (x y))
          e5 (app-exp (lambda-exp 'x (var-exp 'x)) (app-exp (var-exp 'x) (var-exp 'y)))

           ;e6 '(fn [y] (fn [z] (x (y z))))
          e6 (lambda-exp 'y (lambda-exp 'z (app-exp (var-exp 'x) (app-exp (var-exp 'y) (var-exp 'z)))))

          res (map #(occurs-free? 'x %) [e1 e2 e3 e4 e5 e6])]

      (is (= res [true false false true true true])))))
