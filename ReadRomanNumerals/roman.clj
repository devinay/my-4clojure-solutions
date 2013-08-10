;;http://www.4clojure.com/problem/92

(fn[rnum]
   (let [nums (map (fn[n](get {\I 1 \V 5 \X 10 \L 50 \C 100 \D 500 \M 1000} n)) rnum)]
     ((fn mknum[acc prev lst]
   (if (nil? (first lst)) acc
       (if (empty? lst) acc
           (let [curr (first lst) rem (rest lst)]
             (cond
              (nil? prev) (mknum (+ acc curr) curr rem)
              (> curr prev) (mknum (+ (- acc (* 2 prev)) curr) curr rem)
              :else (mknum (+ acc curr) curr rem)))))) 0 nil nums)))