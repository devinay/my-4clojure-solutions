;;http://www.4clojure.com/problem/144

(fn osc [val & funs]
  ((fn tmp [val l-funs]
     (let [rhs ((first l-funs) val)]
       (lazy-seq (cons rhs (tmp rhs (rest l-funs))))))
   val (cons identity (cycle funs))))