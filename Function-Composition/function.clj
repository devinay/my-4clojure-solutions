;;http://www.4clojure.com/problem/58

(fn my[& f]
   (fn [& x]
     ((fn temp[flist]
       (if (empty? (rest flist)) (apply (first flist) x)
           ((first flist) (temp (rest flist))))) f)))