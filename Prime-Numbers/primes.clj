;;http://www.4clojure.com/problem/67

(fn primes[n]
  ;;cheating on range, revisit lazily
    (loop [pset [2] nums (range 3 600)]
      (if (= n (count pset)) pset
          (let [filtered (remove #(zero? (rem % (last pset))) nums)
                next-prime (first filtered)]
            (recur (conj pset next-prime) filtered)))))