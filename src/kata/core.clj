(ns kata.core)
(alias 'string 'clojure.string)

(def world-size {:x 20 :y 20})

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
  [{direction :d :as rover}  to]
    (let [to-direction ((comp (keyword to) (keyword direction)) compass)]
    (assoc rover :d to-direction)))

(defn- move
  [{rover-x :x rover-y :y direction :d :as rover}  to]
  (let [move-horizontally-from (:x ((comp (keyword direction) (keyword to)) gps))
        move-vertically-from (:y ((comp (keyword direction) (keyword to)) gps))]
    (assoc rover :x (mod (move-horizontally-from rover-x) (:x world-size))
                 :y (mod (move-vertically-from rover-y) (:y world-size)))))

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
