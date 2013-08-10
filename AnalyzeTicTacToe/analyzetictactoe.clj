;;http://www.4clojure.com/problem/73

(fn [a]
  (let [both     (reduce #(conj %1 %2) a (vec (for [x (range 3)]
                (vec (for [y (range 3)]
                  (nth (nth a y) x))))))
        
        diags  [(vec (for [xy (range 3)] (nth (nth a xy) xy)))
                (vec (for [xy (reverse (range 3))] (nth (nth a xy) (- 2 xy))))]
        
        fil-n (fn [lol]
                (first (remove nil?
                        (for [idx (range (count lol))]
                          (reduce
                           #(cond
                             (= :x %1 %2) :x
                             (= :o %1 %2) :o
                             :else nil) (nth lol idx))))))
        both-res (fil-n both)
        diags-res (fil-n diags)]
    (first (remove nil? [both-res diags-res]))))