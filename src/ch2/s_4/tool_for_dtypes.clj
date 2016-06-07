;; ;; Author José Albert Cruz Almaguer <jalbertcruz@gmail.com>
;; Copyright 2016 by José Albert Cruz Almaguer.
;;
;; This program is licensed to you under the terms of version 3 of the
;; GNU Affero General Public License. This program is distributed WITHOUT
;; ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
;; MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
;; AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
;;

(ns ch2.s-4.tool-for-dtypes)

(defmacro define-datatype [type-name type-predicate-name & variants]
  (let [predicate `(def ~type-predicate-name
                     (fn [exp#] (= (:type exp#) ~(keyword type-name))))

        constructors (for [[n & r] variants]
                       (let [params (vec (for [[a b] r] a))
                             conditions (for [[a b] r] (list b a))
                             data (into {:type    :lc-exp
                                         :variant (keyword n)} (for [[a _] r] [(keyword a) a]))]

                         `(def ~n
                            (fn ~params
                              (if (and
                                   ~@conditions)
                                ~data
                                false)))))]

    (concat (list 'do predicate)
            constructors)))

(def identifier? symbol?)

(define-datatype lc-exp lc-exp?
  [var-exp
   [var identifier?]]

  [lambda-exp
   [bound-var identifier?]
   [body lc-exp?]]

  [app-exp
   [rator lc-exp?]
   [rand lc-exp?]])

{:type    :lc-exp
 :variant :var-exp
 :var     'x}

{:type      :lc-exp
 :variant   :lambda-exp
 :bound-var 'x
 :body      'y}

{:type    :lc-exp
 :variant :app-exp
 :rator   'x
 :rand    'y}

#_(def lc-exp?
    (fn [exp] (= (:type exp)
                 :lc-exp)))
#_(def var-exp
    (fn [var]
      (if (identifier? var)
        {:type    :lc-exp
         :variant :var-exp
         :var     var}
        false)))

#_(def lambda-exp
    (fn [bound-var body]
      (if (and
           (identifier? bound-var)
           (lc-exp? body))
        {:type      :lc-exp
         :variant   :lambda-exp
         :bound-var bound-var
         :body      body}
        false)))

#_(def app-exp
    (fn [rator rand]
      (if (and
           (lc-exp? rator)
           (lc-exp? rand))
        {:type    :lc-exp
         :variant :app-exp
         :rator   rator
         :rand    rand}
        false)))

(def occurs-free?
  (fn [search-var exp]
    (case (:variant exp)

      :var-exp (let [{:keys [var]} exp]
                 (= var search-var))

      :lambda-exp (let [{:keys [bound-var body]} exp]
                    (and
                     (not= search-var bound-var)
                     (occurs-free? search-var body)))

      :app-exp (let [{:keys [rator rand]} exp]
                 (or
                  (occurs-free? search-var rator)
                  (occurs-free? search-var rand)))
      :error)))

#_(def occurs-free?
    (fn [search-var exp]
      (cases
       lc-exp exp

       var-exp [var] (= var search-var)

       lambda-exp [bound-var body] (and
                                    (not= search-var bound-var)
                                    (occurs-free? search-var body))

       app-exp [rator rand] (or
                             (occurs-free? search-var rator)
                             (occurs-free? search-var rand)))))
