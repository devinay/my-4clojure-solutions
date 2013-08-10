;;http://www.4clojure.com/problem/110


(fn lz-pro[in]
  (when-let [s (seq in)]
    (let [nxt (mapcat #(vector (count %) (first %)) (partition-by identity s))]
      (lazy-seq  (cons nxt (lz-pro nxt))))))