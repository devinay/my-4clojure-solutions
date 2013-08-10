;;http://www.4clojure.com/problem/108

(fn [& lists]
  (loop [in-lists lists]
    (let [f-list (map #(first %) in-lists)
          common-max (apply max-key identity f-list)]
      (if (apply (partial = common-max) f-list) common-max
          (recur (for [l in-lists] (drop-while (partial > common-max) l)))))))