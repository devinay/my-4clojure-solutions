;;http://www.4clojure.com/problem/46

(fn rev[f]
  (fn [x y]
    (f y x)))