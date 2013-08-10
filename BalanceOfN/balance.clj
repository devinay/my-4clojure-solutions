;;http://www.4clojure.com/problem/115

(fn bal[n]
  (let [digits ((fn pd [lst num]
                  (if (= 0 num) lst (pd (cons (rem num 10) lst) (quot num 10)))) [] n)
        ndigits (quot (count digits) 2)
        suml (reduce + (take ndigits digits))
        sumr (reduce + (take ndigits (reverse digits)))]
    (= sumr suml)))