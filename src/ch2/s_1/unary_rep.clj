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

(ns ch2.s-1.unary-rep)

;; Unary Representation
;; page 33

;; tag::unary-rep[]
(def zero (fn [] '()))
(def is-zero? (fn [n] (empty? n)))
(def successor (fn [n] (cons true n)))
(def predecessor (fn [n] (rest n)))

(def clj-int->my-int (fn [n]
                       (if (zero? n) (zero)
                           (successor (clj-int->my-int (- n 1))))))

(def my-int->clj-int (fn [x]
                       (if (is-zero? x) 0
                           (+ 1 (my-int->clj-int (predecessor x))))))
;; end::unary-rep[]
