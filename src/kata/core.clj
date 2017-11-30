(ns kata.core)

(def compass {:N {:R "W" :L "E"}
              :W {:R "S" :L "N"}
              :E {:R "N" :L "S"}
              :S {:R "E" :L "W"}})

(defn- get-head
  [head to]
  (if (clojure.string/blank? to)
    head
    ((keyword to) ((keyword head) compass))))

(defn move-rover [{x :x y :y current-head :heading} commands]
  {:x x :y y :heading (reduce get-head current-head (map str commands))})