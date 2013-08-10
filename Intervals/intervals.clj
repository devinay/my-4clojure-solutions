;;http://www.4clojure.com/problem/171

(fn [inlist]
  (let [sorted (vec (sort inlist))]
    (reduce
     (fn eat[result inarg]
       (if (empty? result) (conj result [inarg inarg])
           (let [[f n] (last result)]
             (if (or (= n inarg) (= (inc n) inarg)) (conj (vec (butlast result)) [f inarg])
                 (conj (vec result) [inarg inarg]))))) [] sorted)))