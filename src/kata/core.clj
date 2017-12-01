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
  [head to]
  (if (clojure.string/blank? to)
    head
    ((keyword to) ((keyword head) compass))))

(defn- move
  [{x :x y :y head :heading :as rover}  to]
  (let [to-x (:x ((keyword head) ((keyword to) gps)))
        to-y (:y ((keyword head) ((keyword to) gps)))]
    (assoc rover :y (+ to-y y) :x (+ to-x x))))


(defn- execute-command
  [{x :x y :y head :heading :as rover}  command]
  (if (clojure.string/includes? "RL" command)
     (assoc rover :heading (orientate head command))
     (move rover command)
     ))

(defn move-rover
  [position  commands]
  (reduce execute-command position (map str commands)))
