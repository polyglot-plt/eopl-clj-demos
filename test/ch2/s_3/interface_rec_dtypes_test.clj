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

(ns ch2.s-3.interface-rec-dtypes-test
  (:require [clojure.test :refer :all]
            [ch2.s-3.interface-rec-dtypes :refer :all]))

(deftest sec-23
  (testing "occurs-free? --> Sec 2.3"

    (let [e1 'x
          e2 'y

          e3 '(fn [x] (x y))

          e4 '(fn [y] (x y))

          e5 '((fn [x] x) (x y))
          e6 '(fn [y] (fn [z] (x (y z))))

          res (map #(occurs-free? 'x %) [e1 e2 e3 e4 e5 e6])]

      (is (= res [true false false true true true])))))
