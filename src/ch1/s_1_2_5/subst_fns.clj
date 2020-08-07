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

(ns ch1.s-1-2-5.subst-fns)

(declare subst)

;; tag::subst-in-s-exp[]
(def subst-in-s-exp
  (fn [new old sexp]
    (if (symbol? sexp)
      (if (= sexp old) new sexp)
      (subst new old sexp))))
;; end::subst-in-s-exp[]

;; tag::subst[]
(def subst
  (fn [new old slist]
    (if (not (seq slist))                           ;; <1>
      '()
      (cons (subst-in-s-exp new old (first slist))  ;; <2>
            (subst new old (rest slist))))))
;; end::subst[]
