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

(ns ch2.s-2.stack-proc-dispatch_test
  (:require [clojure.test :refer :all]
            [ch2.s-2.stack-proc-dispatch :refer :all]))

(deftest exercise-2-12-sol-dispatch
  (testing "stack --> 2.12"
    (let [e (pop
             (pop
              (push 2
                    (push 6
                          (push 3
                                (empty-stack))))))]

      (is (= 3 (top e)))

      (is (= (empty-stack? e) false))

      (is (empty-stack? (pop e)))

      (is (empty-stack? (empty-stack))))))
