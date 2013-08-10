;;http://www.4clojure.com/problem/70

(fn [instr]
  (sort-by #(.toLowerCase %) (.split (.replaceAll instr "[\\.\\!]" "")  " ")))