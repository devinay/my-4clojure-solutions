;;http://www.4clojure.com/problem/98


(fn[f in]
   (set (map #(set %) (partition-by f (sort-by f in)))))