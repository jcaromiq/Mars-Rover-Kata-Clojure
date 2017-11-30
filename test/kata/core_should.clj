(ns kata.core_should
  (:require [midje.sweet :refer :all]
            [kata.core :refer :all]))

(facts
  "Allow Mars Rover to rotate"
  (fact "Left from North"
    (move-rover {:x 0 :y 0 :heading "N"} "L") => {:x 0 :y 0 :heading "W"})

  (fact "Left from West"
        (move-rover {:x 0 :y 0 :heading "W"} "L") => {:x 0 :y 0 :heading "S"})

  )

(facts
  "Allow Mars Rover to "
  (fact "Stays in the same position if no commands getting"
    (move-rover {:x 0 :y 0 :heading "N"} "") => {:x 0 :y 0 :heading "N"})
  ;(fact "move Forward"
  ;  (move-rover {:x 0 :y 0 :heading "N"} "F") => {:x 0 :y 1 :heading "N"})
  )
