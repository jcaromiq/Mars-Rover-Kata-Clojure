(ns kata.core)
; Añadir la lista unicamente de puntos cardinales e ir rotandolas
(def compass {:N {:R "W" :L "E"}
              :E {:R "N" :L "S"}
              :S {:R "E" :L "W"}
              :W {:R "S" :L "N"}})


(defn- orientate
  [head to]
  (if (clojure.string/blank? to)
    head
    ((keyword to) ((keyword head) compass))))

(defn- move
  [rover to]
  (cond
    (and (="F" to) (= "N" (:heading rover))) (assoc rover :y (+ (:y rover) 1))
    (and (="F" to) (= "E" (:heading rover))) (assoc rover :x (+ (:x rover) 1))
    ))

(defn- execute-command
  [{x :x y :y head :heading :as rover}  command]
  (if (clojure.string/includes? "RL" command)
     (assoc rover :heading (orientate head command))
     (move rover command)
     ))

(defn move-rover
  [position  commands]
  (reduce execute-command position (map str commands)))
