;;http://www.4clojure.com/problem/74

(fn[in]
   (apply str
     (map #(.toString %)
      (for [elem (drop 1 (interleave (repeat ",")
                          (filter (fn[d](contains? #{64 1 4 36 9 16 49 25} d))
                                  (for [i (.split in ",")]
                                    (. (new Integer i) (intValue))))))]
       elem))))