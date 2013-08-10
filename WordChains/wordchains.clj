;;http://www.4clojure.com/problem/82

(fn is-list[wordlist]
  (let [one-dif (fn one-dif[w1 w2]
                  (let [cw1 (count w1)
                        cw2 (count w2)
                        cdiff (- cw1 cw2)
                        big-small-comp #(first
                                         (for
                                             [c (for [i (range (count %1))]
                                                  (concat (subvec (vec %1) 0 i) (subvec (vec %1) (inc i))))
                                              :let
                                              [word (apply str c)]
                                              :when
                                              (= 0 (compare word %2))] true))]
                    (cond
                     (or (< cdiff -1) (> cdiff 1)) false
                     (= -1 cdiff) (big-small-comp w2 w1)
                     (= 1 cdiff) (big-small-comp w1 w2)
                     :else (= 1 (count (filter #(= false %) (map = w1 w2)))))))
        ;;;;;;;;;;;;;;;;;;;;;;;;;
        graph ((fn mkmap[inwords]
                   (apply merge
                          (for [word inwords]
                            {word
                             (set
                              (for [each-of-rest (disj inwords word)
                                    :when (one-dif each-of-rest word)] each-of-rest))}))) wordlist)
        ;;;;;;;;;;;;;;;;;;;;;;;;;;;
        pathfound (atom false)
        ;;;;;;;;;;;;;;;;;;;;;;;;;
        try-complete (fn [r]
                       (contains?
                        (set
                         (flatten
                          ((fn try-complete[root visited]
                             (let [v (cons root visited)]
                               (if (or @pathfound (= (set v) wordlist)) [visited (reset! pathfound true)]
                                   (when-let [paths (seq (clojure.set/difference (get graph root) (set v)))]
                                     (for [node paths] (try-complete node v)))))) r []))) true))
        ;;;;;;;;;;;;;;;;;;;;;;;;
        find (map #(try-complete %) (keys graph))
        ;;;;;;;;;;;;;;;;;;;;;;;
        one-found (contains? (set find) true)
        ]
    one-found))