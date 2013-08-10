;;http://www.4clojure.com/problem/50
(fn[i]
  (partition-by #(str (class %)) (sort-by #(count (str (class %))) i)))