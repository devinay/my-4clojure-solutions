;;http://www.4clojure.com/problem/132

(fn ins-lz
  ([f label iter] (ins-lz (first iter) f label (rest iter)))
  ([prev f label coll]
     (if (empty? coll) (if (not (nil? prev)) [prev] [])
     (when-let [iter (seq coll)]
       (if (f prev (first coll))
         (lazy-seq (cons prev (cons label (ins-lz (first iter) f label (rest iter)))))
         (lazy-seq (cons prev (ins-lz (first iter) f label (rest iter)))))))))