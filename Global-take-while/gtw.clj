;;http://www.4clojure.com/problem/114

(fn [n f ls]
  (let [gate (nth (filter f ls) (dec n))]
    (take-while #(not (= gate %)) ls)))