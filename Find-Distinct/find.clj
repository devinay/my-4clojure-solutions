;;http://www.4clojure.com/problem/56

(fn chmp[tgt st coll]
  (if (empty? coll) tgt
      (if (not (contains? st (first coll))) (chmp (conj tgt (first coll)) (conj st (first coll)) (rest coll))
          (chmp tgt st (rest coll))))) [] #{}