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

(ns ch2.s-2.stack-proc)

; Exercise 2.12
;; tag::stack[]
(def empty-stack (fn []
                   (list (fn [e s]
                           (println "Error"))
                         (fn []
                           true))))

(def push (fn [e s]
            (list (fn [m]
                    (m e s))
                  (fn []
                    false))))

(def top (fn [s]
           ((first s) (fn [p q]
                        p))))

(def pop (fn [s]
           ((first s) (fn [p q]
                        q))))

(def empty-stack? (fn [s]
                    ((fnext s))))
;; end::stack[]
