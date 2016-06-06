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

(ns ch1.s-1-4.bin-tree)

; Exercise 1.31
(defn leaf [n]
  {:type :leaf
   :content n})

(defn interior-node [c r l]
  {:type :interior-node
   :content c
   :lson l
   :rson r})

(defn leaf? [t]
  (= :leaf (:type t)))

(defn rson [t]
  (:rson t))

(defn lson [t]
  (:lson t))

(defn contents-of [t]
  (:content t))

; Exercise 1.32

(defn double-tree [t]
  (if (leaf? t)
    (leaf (* 2 (contents-of t)))
    (interior-node (contents-of t)
                   (double-tree (rson t)
                                (lson t)))))

; Exercise 1.33 [* *]

(defn  mark-leaves-with-red-depth-aux [t init]
  (if (leaf? t)
    (leaf init)
    (let [label (contents-of t)
          n (if (= label 'red)
              0
              (inc init))]

      (interior-node label
                     (mark-leaves-with-red-depth-aux (rson t) n)
                     (mark-leaves-with-red-depth-aux (lson t) n)))))

(defn mark-leaves-with-red-depth [t]
  (mark-leaves-with-red-depth-aux t 0))

; Exercise 1.35 [* * *]

(defn number-leaves-aux [t index]
  (if (leaf? t)
    [(leaf index) (inc index)]
    (let [[r nind] (number-leaves-aux (lson t) index)
          [r2 nind2] (number-leaves-aux (rson t) nind)]
      [(interior-node (contents-of t) r r2) nind2])))

(defn number-leaves [t]
  (let [[r _] (number-leaves-aux t 0)]
    r))
