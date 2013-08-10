;;http://www.4clojure.com/problem/43

(fn[coll n]
  (let [in (partition n coll)]
    (for [i (range n)]
      (map #(nth % i) in))))