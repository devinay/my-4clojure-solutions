;;http://www.4clojure.com/problem/53

(fn lis[input]
  (let [li (first (last (partition-by count (sort-by count (filter #(> (count %) 1)
          (partition-by #(= \# %)
                ((fn chop-chop[out in]
                   (cond
                    (empty? in) out
                    (or
                     (nil? (last out))
                     (> (first in) (last out))) (chop-chop (conj out (first in)) (rest in))
                     :else (chop-chop (conj (conj out \#) (first in)) (rest in))))
                 [] input)))))))]
    (if (nil? li) [] li)))