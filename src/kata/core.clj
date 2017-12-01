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

(defn move-rover
  [{x :x y :y head :heading :as position}  commands]
  (assoc position :heading (reduce orientate head (map str commands))))