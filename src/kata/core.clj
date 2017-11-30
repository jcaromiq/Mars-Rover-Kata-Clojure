(ns kata.core)

(defn move-rover [initial-position commands]
  (if (clojure.string/blank? commands)
    initial-position
    (let [x (:x initial-position)
          y (:y initial-position)
          heading (:heading initial-position)]
      (if (and (= heading "N") (= commands "L"))
        {:x x :y y :heading "W"}
        ))
    )
  )
