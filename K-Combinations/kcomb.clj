;;http://www.4clojure.com/problem/103

(fn[k in-set]
   (if (> k (count in-set)) #{}
   (loop [k-set #{in-set}]
     (if (= k (count (first k-set))) k-set
         (let [next-k-set (set (reduce #(clojure.set/union %1 %2)
                                       (for [one-set k-set]
                                         (for [elem one-set] (disj one-set elem)))))]
           (recur next-k-set))))))