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

(ns ch2.s-2.environment-ribcage_test
  (:require [clojure.test :refer :all]
            [ch2.s-2.environment-ribcage :refer :all]))

(deftest exercise-2-11
  (testing "environment ribcage (data structure) representation --> Sec 2.2.2, exercise 2.11"

    (let [e (extend-env 'd 6
                        (extend-env 'y 8
                                    (extend-env 'x 7
                                                (extend-env 'y 14
                                                            (empty-env)))))
          vrs (list 't 'z 'x 'p)

          vls (list 9 22 5 1)

          e1 (extend-env* vrs vls e)]

      (is (= 8 (apply-env e 'y)))

      (is (= 7 (apply-env e 'x)))

      (is (= 5 (apply-env e1 'x)))

      (is (= (has-binding? e 't)) false)

      (is (has-binding? e 'y))

      (is (has-binding? e1 't)))))
