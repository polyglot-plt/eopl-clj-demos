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

(ns ch2.s-2.stack-proc-dispatch)

(def empty-stack (fn []
                   (fn [dispatch]
                     (case dispatch
                       '(:top :pop) (println "Error")
                       :empty-stack? true))))

(def push (fn [e s]
            (fn [dispatch]
              (case dispatch
                :top e
                :pop s
                :empty-stack? false))))

(def top (fn [s]
           (s :top)))

(def pop (fn [s]
           (s :pop)))

(def empty-stack? (fn [s]
                    (s :empty-stack?)))
