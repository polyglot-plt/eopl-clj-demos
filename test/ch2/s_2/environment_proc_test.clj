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

(ns ch2.s-2.environment-proc_test
  (:require [clojure.test :refer :all]
            [ch2.s-2.environment-proc :refer :all]))

(deftest sec-223
  (testing "occurs-free? --> Sec 2.2.3"

    (let [e (extend-env 'd 6
                        (extend-env 'y 8
                                    (extend-env 'x 7
                                                (extend-env 'y 14
                                                            (empty-env)))))]
      (is (= 8 (apply-env e 'y))))))
