;;http://www.4clojure.com/problem/131

(fn[& sets]
   (if (= 1 (count sets)) true
  (let [sums-set (map (fn myfn [in-set]
                      (set (map #(reduce + %)
                                (remove #(empty? %)
                                ((fn mcombs [& in]
                                   (loop [acc #{(first in)} prev-combs in]
                                     (if (empty? (first prev-combs)) acc
                                         (let [next-combs (set (reduce #(clojure.set/union %1 %2)
                                                                       (for [one-set prev-combs]
                                                                         (for [elem one-set] (disj one-set elem)))))
                                               next-acc (clojure.set/union acc next-combs)]
                                           (recur next-acc next-combs))))) in-set))))) sets)]
;;    sums-set)))
    (not (empty? (reduce #(clojure.set/intersection %1 %2) sums-set))))))