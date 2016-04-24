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

(ns ch2.s-1.bignum-rep)

(def N 4)
;; Bignum representation
;; page 34
(def zero (fn [] '(0)))
(def is-zero? (fn [n] (every? #(= 0 %) n)))

(def successor (fn [n]
                 (let [p (first n)
                       t (rest n)]
                   (if (= (inc p) N)
                     (cons 0 (successor (if (= t '())
                                          '(0)
                                          t)))
                     (cons (inc p) t)))))

(def predecessor (fn [n]
                   (let [p (first n)
                         t (rest n)]
                     (if (= p 0)
                       (cons (dec N)
                             (predecessor t))
                       (cons (dec p) t)))))
