;;http://www.4clojure.com/problem/77

(fn[sow]
   (set (for[e (group-by sort sow) :when (> (count (fnext e)) 1)] (set (fnext e)))))