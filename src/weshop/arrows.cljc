(ns weshop.arrows
  #?(:cljs (:require-macros weshop.arrows)))

(defmacro ->%
  "Creates an anonymous function, threading the parameter through the
  forms provided as the first parameter.

  Useful for getting around the restriction that you're not allowed to
  have nested anonymous functions (of the #() variety), especially
  when manipulating lists of maps - i.e.:

  (let [table [{:a 1 :b [4 12]},
               {:a 3 :b [8 35]}]]
    (map (->% (update :b #(map inc %))
              (assoc :c 8))
         table))

  ;; -> [{:a 1, :b [5 13], :c 8},
  ;;     {:a 3, :b [9 36], :c 8}]"

  [& forms]

  `(fn [%#]
     (-> %#
         ~@forms)))

(defmacro ->>%
  "Creates an anonymous function, threading the parameter through the
  forms provided as the last parameter.

  Useful for getting around the restriction that you're not allowed to
  have nested anonymous functions (of the #() variety), especially
  when manipulating nested lists - i.e.:

  (let [results [[3 5 8 12], [6 45 23 18]]]
    (map (->>% (filter #(zero? (mod % 3)))
               (map #(* 2 %)))
         results))

  ;; -> [[6 24], [12 90 36]]"

  [& forms]

  `(fn [%#]
     (->> %#
          ~@forms)))
