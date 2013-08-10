;;http://www.4clojure.com/problem/93

(fn[x]
  (filter #(and (coll? %1) (not (coll? (first %1)))) (tree-seq coll? identity x)))