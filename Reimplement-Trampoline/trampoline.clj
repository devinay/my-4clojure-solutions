;;http://www.4clojure.com/problem/78

(fn t-clone[f & args]
  (loop [fun (apply f args)]
    (if (not (fn? fun)) fun
        (recur (fun)))))