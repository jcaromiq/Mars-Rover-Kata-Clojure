(ns kata.core)
(alias 'string 'clojure.string)

(def compass {:N {:L "E" :R "W"}
              :E {:L "S" :R "N" }
              :S {:L "W" :R "E" }
              :W {:L "N" :R "S" }})
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

(defn- rotate
  [{head :heading :as rover}  to]
    (let [to-heading ((comp (keyword to) (keyword head)) compass)]
    (assoc rover :heading to-heading)))

(defn- move
  [{rover-x :x rover-y :y rover-head :heading :as rover}  to]
  (let [move-x-from (:x ((comp (keyword rover-head) (keyword to)) gps))
        move-y-from (:y ((comp (keyword rover-head) (keyword to)) gps))]
    (assoc rover :x (move-x-from rover-x) :y (move-y-from rover-y))))

(defn- valid-rotate?
  [to]
  (string/includes? "LR" to))

(defn- valid-move?
  [to]
  (string/includes? "FB" to))

(defn- place
  [rover to]
  (cond
    (valid-rotate? to) (rotate rover to)
    (valid-move? to) (move rover to)
    :else rover))

(defn move-rover
  [rover commands]
  (reduce place rover (map str commands)))
