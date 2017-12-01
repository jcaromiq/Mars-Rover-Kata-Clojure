(ns kata.core)
(def compass {:N {:R "W" :L "E"}
              :E {:R "N" :L "S"}
              :S {:R "E" :L "W"}
              :W {:R "S" :L "N"}})
(def gps {:F
          {:N {:y 1 :x 0}
           :E {:y 0 :x 1}
           :W {:y 0 :x -1}
           :S {:y -1 :x 0}}
          :B
          {:N {:y -1 :x 0}
           :E {:y 0 :x -1}
           :W {:y 0 :x 1}
           :S {:y 1 :x 0}}})

(defn- orientate
  [{head :heading :as rover}  to]
    (let [to-heading ((keyword to) ((keyword head) compass))]
    (assoc rover :heading to-heading)))

(defn- move
  [{x :x y :y head :heading :as rover}  to]
  (let [to-x (:x ((keyword head) ((keyword to) gps)))
        to-y (:y ((keyword head) ((keyword to) gps)))]
    (assoc rover :y (+ to-y y) :x (+ to-x x))))

(defn- place
  [rover to]
  (if (clojure.string/includes? "RL" to)
    (orientate rover to)
    (move rover to)))

(defn move-rover
  [rover commands]
  (reduce place rover (map str commands)))
