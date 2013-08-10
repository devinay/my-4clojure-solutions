;;;;http://www.4clojure.com/problem/112

(fn sum
  ([limit in] (sum (atom 0) limit in))
  ([count limit in]
     (let [val (when-let [s (seq in)]
                  (let [f (first s)
                        r (rest s)]
                    (when-let
                        [sentinel
                         (if (coll? f) true
                             (<= (reset! count (+ @count  f)) limit))]
                      (if (coll? f)
                        (cons (sum count limit f)
                              (sum count limit r))
                        (cons f (sum count limit r))))))]
       (if (nil? val) '() val))))