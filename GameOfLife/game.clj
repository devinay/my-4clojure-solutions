;;http://www.4clojure.com/problem/94

(fn lifegame[in-arr]
  (let [get-at (fn[arr x y](nth (nth arr y) x))
        get-num (fn [arr x y]
                  (count
                   (filter #(= \# %)
                           (for [i (range (dec x) (inc (inc x))) j (range (dec y) (inc (inc y)))
                                 :when (and (and (>= i 0) (>= j 0))
                                            (and (< i (count arr)) (< j (count arr)))
                                            (or (not (= x i)) (not (= y j))))]
                             (get-at arr i j)))))]
    (map #(apply str %) (partition (count (first in-arr)) (for [y (range (count in-arr))
                                                                x (range (count (first in-arr)))]
                                                            (let [elem (get-at in-arr x y)
                                                                  count (get-num in-arr x y)]
                                                              (if (= \# elem)
                                                                (cond
                                                                 (< count 2) \space
                                                                 (> count 3) \space
                                                                 :else \#)
                                                                (if (= count 3) \# \space))))))))