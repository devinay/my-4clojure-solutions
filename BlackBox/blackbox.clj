;;http://www.4clojure.com/problem/65

(fn what?[coll]
  (if (not (associative? coll)) (if (= (conj coll 1) (conj (conj coll 1) 1)) :set :list)
      (if(reversible? coll) :vector :map)))