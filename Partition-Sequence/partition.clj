;;http://www.4clojure.com/problem/54

(fn bl[tgt n lst]
  (if (< (count lst) n) (reverse tgt)
      (bl (cons (take n lst) tgt) n (drop n lst)))) '()