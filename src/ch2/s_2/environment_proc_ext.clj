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

(ns ch2.s-2.environment-proc-ext)

(def report-no-binding-found
  (fn [search-var]
    (println "Error:" 'apply-env (format "No binding for %s" search-var))))

(def report-invalid-env
  (fn [env]
    (println "Error:" 'apply-env (format "Bad environment: %s" env))))

(def apply-env
  (fn [env search-var]
    ((first env) search-var)))

(def empty-env
  (fn []
    (list (fn [search-var]
            (report-no-binding-found search-var))
          (fn []
            true)
          (fn [search-var]
            false))))

(def has-binding?
  (fn [env s]
    ((nth env 2) s)))

(def extend-env
  (fn [saved-var saved-val saved-env]

    (list (fn [search-var]
            (if (= search-var saved-var)
              saved-val
              (apply-env saved-env search-var)))
          (fn []
            false)
          (fn [search-var]
            (or (= search-var saved-var)
                (has-binding? saved-env search-var))))))

(def empty-env?
  (fn [env]
    ((fnext env))))
