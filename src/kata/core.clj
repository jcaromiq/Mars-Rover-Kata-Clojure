(ns kata.core)

(defn move-rover [initial-position commands]
  (if (clojure.string/blank? commands)
    initial-position))
