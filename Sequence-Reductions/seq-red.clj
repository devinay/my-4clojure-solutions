;;http://www.4clojure.com/problem/60

(fn lazy-red
  ([f lastval in]
     (when-let [a (first in)]
       (lazy-seq (cons lastval (lazy-red f lastval in nil)))))
  ([f lastval in junk]
     (when-let [a (first in)]
       (let [val (f lastval (first in))]
         (lazy-seq (cons val (lazy-red f val (rest in) nil))))))
  ([f in]
     (when-let [a (first in)]
       (lazy-seq (cons (f (first in)) (lazy-red f (f (first in)) (rest in) nil))))))