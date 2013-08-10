;;http://www.4clojure.com/problem/85

(fn [& in]
  (loop [acc (set [#{} (first in)]) prev-combs in]
    (if (empty? (first prev-combs)) acc
        (let [next-combs (set (reduce #(clojure.set/union %1 %2)
                                      (for [one-set prev-combs]
                                        (for [elem one-set] (disj one-set elem)))))
              next-acc (clojure.set/union acc next-combs)]
          (recur next-acc next-combs)))))