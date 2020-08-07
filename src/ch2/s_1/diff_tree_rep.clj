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

(ns ch2.s-1.diff-tree-rep)

;; Diff-tree representation
;; page 34

;; tag::diff-tree-rep[]
(def zero (fn []
            '(diff (one) (one))))

(def minus-one (list 'diff (zero) '(one)))

(def diff-value (fn [n]
                  (if (= n '(one))
                    1
                    (let [[_ i d] n
                          izq (diff-value i)
                          der (diff-value d)]
                      (- izq der)))))

(def is-zero? (fn [n]
                (let [[e i d] n]
                  (and (= e 'diff)
                       (= (diff-value i)
                          (diff-value d))))))

(def successor (fn [n]
                 (list 'diff n minus-one)))

(def predecessor (fn [n]
                   (list 'diff n '(one))))

(def plus (fn [x y]
            (list 'diff x (list 'diff (zero) y))))

(def diff-tree-equals? (fn [x y]
                         (= (diff-value x) (diff-value y))))
;; end::diff-tree-rep[]
