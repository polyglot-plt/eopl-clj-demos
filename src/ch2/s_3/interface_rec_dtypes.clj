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

(ns ch2.s-3.interface-rec-dtypes)

; constructors
(def var-exp
  (fn [var]
    var))

(def lambda-exp
  (fn [var exp]
    (list 'fn [var] exp)))

(def app-exp
  (fn [exp1 exp2]
    (list exp1 exp2)))

; predicates
(def var-exp?
  (fn [exp]
    (symbol? exp)))

(def lambda-exp?
  (fn [exp]
    (= (first exp) 'fn)))

(def app-exp?
  (fn [exp]
    (and
     (= 2 (count exp))
     (not= (first exp) 'fn))))

; extractors
(def var-exp->var
  (fn [exp]
    exp))

(def lambda-exp->bound-var
  (fn [exp]
    (ffirst (rest exp))))

(def lambda-exp->body
  (fn [exp]
    (rest (rest exp))))

(def app-exp->rator
  (fn [exp]
    (first exp)))

(def app-exp->rand
  (fn [exp]
    (first (rest exp))))

;; tag::occurs-free?[]
(def occurs-free?
  (fn [search-var exp]
    (cond
      (var-exp? exp)

      (= search-var (var-exp->var exp))

      (lambda-exp? exp)

      (and
       (not (= search-var (lambda-exp->bound-var exp)))
       (occurs-free? search-var (lambda-exp->body exp)))

      :else (or
             (occurs-free? search-var (app-exp->rator exp))
             (occurs-free? search-var (app-exp->rand exp))))))
;; end::occurs-free?[]
