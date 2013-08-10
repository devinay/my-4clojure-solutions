;;http://www.4clojure.com/problem/75
;;If it werent for google I wouldnt know what 'Eulers totient' meant.


(fn eu-tot[n]
   (if (= n 1) 1
   (count
    (filter #(= 1 %)
            (map (partial
                  (fn gcd[l r](cond
                               (= 0 l) r
                               (= 0 r) l
                               (= l r) r
                               (> l r) (gcd (- l r) r)
                               (> r l) (gcd (- r l) l))) n)
                 (range 1 n))))))