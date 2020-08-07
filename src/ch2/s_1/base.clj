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

(ns ch2.s-1.base)

(declare ^:dynamic zero
         ^:dynamic is-zero?
         ^:dynamic successor
         ^:dynamic predecessor)

;; tag::plus[]
(def plus (fn [x y]
            (if (is-zero? x)
              y
              (successor (plus (predecessor x) y)))))
;; end::plus[]
