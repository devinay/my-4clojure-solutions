;;http://www.4clojure.com/problem/44

(fn shift[n coll]
  (let [k (if ( < n 0) (+ n (count coll)) n)]
  (if (= 0 k) coll
      (shift (dec k) (conj (apply vector (drop 1 coll)) (first coll))))))