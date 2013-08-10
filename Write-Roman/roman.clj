;;http://www.4clojure.com/problem/104

(fn do-rom[number]((fn mkrom [rnums n]
                      (cond
                       (= 0 n) (apply str rnums)
                       (= 1 n) "I"
                       :else
       (let [bkmp (sorted-map 100 \C 10 \X 1 \I)
             mp (sorted-map 1000 \M 500 \D 100 \C 50 \L 10 \X 5 \V 1 \I)
             times (apply merge (reverse (map #(sorted-map (quot n (first %)) (last %)) mp)))
             rmap {\M 1000, \D 500, \C 100, \L 50, \X 10, \V 5, \I 1}
             check (if (zero? (first (first times))) (first (first (rest times)))
                       (first (first times)))
             n-check (if (zero? (first (first times))) (last (first (rest times)))
                         (last (first times)))
             minus (last (filter #(< (first %) n) bkmp))
             postminus (last (first times))
             f-rom-num (if (< check 4) (repeat check n-check)
                         (vector (last minus) postminus))
             f-num (if (< check 4) (* check (get rmap (first f-rom-num)))
                     (- (get rmap (last f-rom-num)) (get rmap (first f-rom-num))))
             t-rom-num (vector (last minus) postminus)
             t-num (- (get rmap postminus) (get rmap (last minus)))
             use-t (and (>= (- n t-num) 0) (< (- n t-num) (- n f-num)))
             rom-num (if use-t t-rom-num f-rom-num)
             num (if use-t t-num f-num)]
         (mkrom (flatten (cons rnums rom-num)) (- n num))))) [] number))