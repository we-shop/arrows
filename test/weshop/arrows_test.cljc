(ns weshop.arrows-test
  (:require [#?(:clj clojure.test, :cljs cljs.test) :as t]
            [weshop.arrows :refer [->% ->>%]]))

(t/deftest thread-first
  (t/testing "essential"
    (t/is (= ((->% (conj :c)) [:a :b])
             [:a :b :c]))))

(t/deftest thread-last
  (t/testing "essential"
    (t/is (= ((->>% (conj [:a :b])) :c)
             [:a :b :c]))))
