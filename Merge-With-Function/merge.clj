;;http://www.4clojure.com/problem/69

(fn[f & maps]
   (reduce
    (fn [m1 m2]
      (apply
       (partial merge m1)
       (for [kv m2]
         (if (contains? m1 (first kv))
           {(first kv) (f (get m1 (first kv)) (fnext kv))}
           {(first kv) (fnext kv)})))) maps))