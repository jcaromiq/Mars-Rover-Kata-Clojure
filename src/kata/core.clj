(ns kata.core)

(def compass {:N {:L "W" :R "E"}
              :W {:L "S" :R "N"}
              :E {:L "N" :R "S"}
              :S {:L "W" :R "E"}})

(defn- get-head
  [head to]
  (if (clojure.string/blank? to)
    head
    ((keyword to) ((keyword head) compass))))

(defn move-rover [{x :x y :y current-head :heading} commands]
  {:x x :y y :heading (get-head current-head commands)})
