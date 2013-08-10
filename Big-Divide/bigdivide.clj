;;http://www.4clojure.com/problem/148

(fn my-inc[n a b]
   (let [f (fn[num div]
             (let [lf (if (= 0 (rem num div))
                        (quot (dec num) div)
                        (quot num div))]
               (* div (/ (* lf (inc lf)) 2))))]
               (- (+ (f n a) (f n b)) (f n (* a b)))))