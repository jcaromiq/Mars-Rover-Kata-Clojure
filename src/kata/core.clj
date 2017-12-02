(ns kata.core)
(alias 's 'clojure.string)

(def compass {:N {:R "W" :L "E"}
              :E {:R "N" :L "S"}
              :S {:R "E" :L "W"}
              :W {:R "S" :L "N"}})
(def gps {:F
          {:N {:y inc :x identity}
           :E {:y identity :x inc}
           :W {:y identity :x dec}
           :S {:y dec :x identity}}
          :B
          {:N {:y dec :x identity}
           :E {:y identity :x dec}
           :W {:y identity :x inc}
           :S {:y inc :x identity}}})

(defn- orientate
  [{head :heading :as rover}  to]
    (let [to-heading ((keyword to) ((keyword head) compass))]
    (assoc rover :heading to-heading)))

(defn- move
  [{x :x y :y head :heading :as rover}  to]
  (let [move-x-from (:x ((keyword head) ((keyword to) gps)))
        move-y-from (:y ((keyword head) ((keyword to) gps)))]
    (assoc rover :y (move-y-from y) :x (move-x-from x))))

(defn- place
  [rover to]
  (if (s/includes? "RL" to)
    (orientate rover to)
    (move rover to)))

(defn move-rover
  [rover commands]
  (reduce place rover (map str commands)))
