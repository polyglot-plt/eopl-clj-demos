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

(ns ch1.s-1-4.exercises)

(def duple
  (fn [n x]
    (if (= n 1)
      (list x)
      (cons x (duple (dec n) x)))))

(def invert
  (fn [l]
    (if (seq l)
      (let [h (first l)
            t (rest l)]
        (cons (list (second h) (first h)) (invert t)))
      '())))


; Exercise 1.36 [* * *]

(defn inc-by-one [l]
  (if (seq lst)
    (let [h (first l)
          t (rest l)
          ]
      (cons (list (inc (first h))
                  (second h))
            (inc-by-one t)))
    '()))

(defn g [l1 l2]
  (let [i (first l1)]
    (cons l1 (inc-by-one l2))))

(defn number-elements [lst]
  (if (not (seq lst))
    '()
    (g (list 0 (first lst))
       (number-elements (rest lst)))))
