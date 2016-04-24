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

(ns ch1.s-1-2-4.lambda-occurs-free)

(def occurs-free?
  (fn [var exp]
    (cond
      (symbol? exp) (= var exp)

      (= (first exp) 'fn) (and
                           (not= var (ffirst (rest exp)))
                           (occurs-free? var (rest (rest exp))))
      :else (or
             (occurs-free? var (first exp))
             (occurs-free? var (first (rest exp)))))))
