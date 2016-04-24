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

(ns ch2.s-1.data_abstraction_test
  (:require [clojure.test :refer :all]
            [ch2.s-1.base :refer [plus]]
            [ch2.s-1.unary-rep :as ur]
            [ch2.s-1.bignum-rep :as bnr]
            [ch2.s-1.clj-rep :as cljr]
            [ch2.s-1.diff-tree-rep :as dtr]))

(deftest sec-2-1
  (testing "plus? --> Sec 2.1"
    (let [diff-tree-value_1 '(diff
                              (diff
                               (one)
                               (diff
                                (diff
                                 (one)
                                 (one))
                                (one)))
                              (diff
                               (diff
                                (one)
                                (one))
                               (one)))
          diff-tree-value_2 '(diff (one)
                                   (diff
                                    (diff (one)
                                          (one))
                                    (one)))
          diff-tree-value_3 '(diff
                              (diff
                               (diff
                                (diff (one)
                                      (diff
                                       (diff (one)
                                             (one))
                                       (one)))
                                (diff
                                 (diff (one)
                                       (one))
                                 (one)))
                               (diff
                                (diff (one)
                                      (one))
                                (one)))
                              (diff
                               (diff
                                (one)
                                (one))
                               (one)))]
      (is
       (=
        (with-bindings
          {#'ch2.s-1.base/zero        ur/zero
           #'ch2.s-1.base/is-zero?    ur/is-zero?
           #'ch2.s-1.base/successor   ur/successor
           #'ch2.s-1.base/predecessor ur/predecessor}

          (plus (list true true)
                (list true)))

        (list true true true)))

      (is
       (=
        (with-bindings
          {#'ch2.s-1.base/zero        bnr/zero
           #'ch2.s-1.base/is-zero?    bnr/is-zero?
           #'ch2.s-1.base/successor   bnr/successor
           #'ch2.s-1.base/predecessor bnr/predecessor}

          (plus (list 2 0 1)
                (list 1 2)))

        (list 3 2 1)))

      (is
       (=
        (with-bindings
          {#'ch2.s-1.base/zero        cljr/zero
           #'ch2.s-1.base/is-zero?    cljr/is-zero?
           #'ch2.s-1.base/successor   cljr/successor
           #'ch2.s-1.base/predecessor cljr/predecessor}

          (plus 23 54))

        77))

      (is
       (=
        (with-bindings
          {#'ch2.s-1.base/zero        dtr/zero
           #'ch2.s-1.base/is-zero?    dtr/is-zero?
           #'ch2.s-1.base/successor   dtr/successor
           #'ch2.s-1.base/predecessor dtr/predecessor}

          (dtr/diff-value (plus diff-tree-value_1
                                diff-tree-value_2)))

        (dtr/diff-value diff-tree-value_3)))

      (is
       (=
        (with-bindings
          {#'ch2.s-1.base/zero        dtr/zero
           #'ch2.s-1.base/is-zero?    dtr/is-zero?
           #'ch2.s-1.base/successor   dtr/successor
           #'ch2.s-1.base/predecessor dtr/predecessor}

          (dtr/diff-value (dtr/plus diff-tree-value_1
                                    diff-tree-value_2)))

        (dtr/diff-value diff-tree-value_3))))))
