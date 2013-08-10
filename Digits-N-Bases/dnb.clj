;;http://www.4clojure.com/problem/137

(fn pd [lst num base]
   (if (and (empty? lst) (= 0 num)) [0]
   (if (= 0 num) lst (pd (cons (rem num base) lst) (quot num base) base)))) []