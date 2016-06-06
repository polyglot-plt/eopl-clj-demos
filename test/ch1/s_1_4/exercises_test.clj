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

(ns ch1.s-1-4.exercises-test
  (:require [clojure.test :refer :all]
            [ch1.s-1-4.exercises :refer :all]))

(deftest ^:sec-1-4 sec-14
  (testing "duple"

    (is (= (duple 2 3)
           '(3 3)))

    (is (= (duple 4 '(ha ha))
           '((ha ha) (ha ha) (ha ha) (ha ha))))

    (is (= (invert '((a 1) (a 2) (1 b) (2 b)))
           '((1 a) (2 a) (b 1) (b 2))))))
