;;http://www.4clojure.com/problem/158

(fn decurry[fns]
  (fn [& args]
    (loop [f fns a args]
      (if (not (fn? (f (first a)))) (f (first a))
          (recur (f (first a)) (rest a))))))