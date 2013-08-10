;;http://www.4clojure.com/problem/86

(fn happy?[journey in-num]
  (let [sum-squares ((fn sumsq[lst num]
                       (if (= (quot num 10) 0) (reduce + (map #(* % %) (conj lst (rem num 10))))
                           (sumsq (conj lst (rem num 10)) (quot num 10)))) [] in-num)]
    (if (= 1 sum-squares) true
        (if (contains? journey sum-squares) false (happy? (conj journey sum-squares) sum-squares))))) #{}