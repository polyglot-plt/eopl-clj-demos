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

(ns ch1.s-1-2-5.sec-1-2-5-test
  (:require [clojure.test :refer :all]
            [ch1.s-1-2-5.subst-fns :refer :all]))

(deftest ^:sec-1-2-5 sec-125
  (testing "substs" (is (= (subst 'a 'b '((b c) (b () d))) '((a c) (a () d))))))
