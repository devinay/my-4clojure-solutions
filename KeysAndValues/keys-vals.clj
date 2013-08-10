;;http://www.4clojure.com/problem/105

(fn ikey[mymap incoll]
  (if (empty? incoll) mymap
      (let [key (first incoll)
            val (take-while #(not (keyword? %)) (rest incoll))
            nxt-map (assoc mymap key val)
            nxt-coll (drop-while #(not (keyword? %)) (rest incoll))]
        (ikey nxt-map nxt-coll)))) {}