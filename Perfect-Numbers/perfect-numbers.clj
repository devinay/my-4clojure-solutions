;;http://www.4clojure.com/problem/80

(fn[n]
  (= n (reduce + (filter #(= 0 (rem n %)) (range 1 n)))))