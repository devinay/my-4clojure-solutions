;; http://www.4clojure.com/problem/55

(fn[coll]
   (apply merge (for [i (partition-by identity (sort coll))] {(first i) (count i)})))