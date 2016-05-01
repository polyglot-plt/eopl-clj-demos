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

(ns ch2.s-2.environment-clj)

(def report-no-binding-found
  (fn [search-var]
    (println "Error:" 'apply-env (format "No binding for %s" search-var))))

(def report-invalid-env
  (fn [env]
    (println "Error:" 'apply-env (format "Bad environment: %s" env))))

(def apply-env
  (fn [env search-var]
    (let [res (env search-var)]
      (if-not res
        (report-invalid-env env)
        res))))

(def empty-env
  (fn [] {}))

(def extend-env
  (fn [var val env] (assoc env var val)))
