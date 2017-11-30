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

(defn move-rover [initial-position commands]
    (let [x (:x initial-position)
          y (:y initial-position)
          heading (:heading initial-position)]
      {:x x :y y :heading (get-head heading commands)}))
