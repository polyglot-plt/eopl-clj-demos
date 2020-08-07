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

(ns ch1.s-1-4.bin-search-tree)

; Exercise 1.34 [* * *]

(comment
  (defn path-aux [n t paths]
    (if (= n (contents-of t))
      paths
      (if (< n (contents-of t))
        (path-aux n (lson t) (cons 'left paths))
        (path-aux n (rson t) (cons 'right paths)))))

  (defn path [n t]
    (reverse (path-aux n t '()))))
