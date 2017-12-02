(ns kata.core)
(alias 'string 'clojure.string)

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
  [{rover-x :x rover-y :y rover-head :heading :as rover}  to]
  (let [move-x-from (:x ((keyword rover-head) ((keyword to) gps)))
        move-y-from (:y ((keyword rover-head) ((keyword to) gps)))]
    (assoc rover :x (move-x-from rover-x) :y (move-y-from rover-y))))

(defn- place
  [rover to]
  (if (string/includes? "RL" to)
    (orientate rover to)
    (move rover to)))

(defn move-rover
  [rover commands]
  (reduce place rover (map str commands)))
