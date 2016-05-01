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

(ns ch2.s-2.environment-a-list)

(def report-no-binding-found
  (fn [search-var]
    (println "Error:" 'apply-env (format "No binding for %s" search-var))))

(def report-invalid-env
  (fn [env]
    (println "Error:" 'apply-env (format "Bad environment: %s" env))))

(def empty-env
  (fn []
    '()))

(def extend-env
  (fn [var val env]
    (list (list var val) env)))

(def apply-env
  (fn [env search-var]
    (cond

      (= env (empty-env)) (report-no-binding-found search-var)

      (= (count env) 2) (let [[[saved-var saved-val] saved-env] env]
                          (if (= search-var saved-var)
                            saved-val
                            (apply-env saved-env search-var)))

      :else (report-invalid-env env))))

(def empty-env?
  (fn [env]
    (= env (empty-env))))
