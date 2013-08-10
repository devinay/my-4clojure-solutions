;;http://www.4clojure.com/problem/102

(fn camel[in]
  ((fn mkcam[acc wrd]
     (cond
      (nil? (first wrd)) (apply str acc)
      (= \- (first wrd)) (mkcam (conj acc (char (- (int (fnext wrd)) 32))) (next (next wrd)))
      :else (mkcam (conj acc (first wrd)) (rest wrd)))) [(first in)] (rest in)))