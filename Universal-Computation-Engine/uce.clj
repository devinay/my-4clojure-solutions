;;http://www.4clojure.com/problem/121

(fn calc [form]
    (fn[sym-map]
      (let [f-map {'/ / '* * '+ + '- -}
            strip (fn [c](map #(f-map % %) (map #(sym-map % %) c)))
            r-strip (fn r-strip[coll]
                        (let [curr-lvl (strip coll)]
                          (if (empty? (filter seq? curr-lvl))
                            (apply (first curr-lvl) (rest curr-lvl))
                            (r-strip (map #(if (seq? %) (r-strip %) %) curr-lvl)))))]
        (r-strip form))))