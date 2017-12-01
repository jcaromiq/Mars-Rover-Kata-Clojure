(ns kata.core_should
  (:require [midje.sweet :refer :all]
            [kata.core :refer :all]))

(facts
  "Allow Mars Rover to rotate to left from"
  (fact "North"
        (move-rover {:x 0 :y 0 :heading "N"} "L") => {:x 0 :y 0 :heading "E"})
  (fact "West"
        (move-rover {:x 0 :y 0 :heading "W"} "L") => {:x 0 :y 0 :heading "N"})
  (fact "South"
        (move-rover {:x 0 :y 0 :heading "S"} "L") => {:x 0 :y 0 :heading "W"})
  (fact "East"
        (move-rover {:x 0 :y 0 :heading "E"} "L") => {:x 0 :y 0 :heading "S"}))

(facts
  "Allow Mars Rover to rotate to right from"
  (fact "North"
        (move-rover {:x 0 :y 0 :heading "N"} "R") => {:x 0 :y 0 :heading "W"})
  (fact "West"
        (move-rover {:x 0 :y 0 :heading "W"} "R") => {:x 0 :y 0 :heading "S"})
  (fact "South"
        (move-rover {:x 0 :y 0 :heading "S"} "R") => {:x 0 :y 0 :heading "E"})
  (fact "East"
        (move-rover {:x 0 :y 0 :heading "E"} "R") => {:x 0 :y 0 :heading "N"})
  (fact "East with double rotation"
        (move-rover {:x 0 :y 0 :heading "S"} "RR") => {:x 0 :y 0 :heading "N"}))

(facts
  "Allow Mars Rover to rotate on itself"
  (fact "same direction"
        (move-rover {:x 0 :y 0 :heading "S"} "RR") => {:x 0 :y 0 :heading "N"})
  (fact "with different directions"
        (move-rover {:x 0 :y 0 :heading "N"} "RRLRLRL") => {:x 0 :y 0 :heading "W"})
  (fact "returning to initial position"
        (move-rover {:x 0 :y 0 :heading "S"} "RL") => {:x 0 :y 0 :heading "S"}))

(facts
  "Allow Mars Rover to "
  (fact "Stay in the same position if no commands getting"
        (move-rover {:x 0 :y 0 :heading "N"} "") => {:x 0 :y 0 :heading "N"})
  (fact "move Forward to North"
    (move-rover {:x 0 :y 0 :heading "N"} "F") => {:x 0 :y 1 :heading "N"})
  (fact "move Forward to East"
        (move-rover {:x 0 :y 0 :heading "E"} "F") => {:x 1 :y 0 :heading "E"})
  (fact "move Forward to South"
        (move-rover {:x 0 :y 4 :heading "S"} "F") => {:x 0 :y 3 :heading "S"})
  (fact "move Forward to West"
        (move-rover {:x 1 :y 0 :heading "W"} "F") => {:x 0 :y 0 :heading "W"})
  (fact "move BackForward to North"
        (move-rover {:x 4 :y 4 :heading "N"} "B") => {:x 4 :y 3 :heading "N"})
  (fact "move BackForward to East"
        (move-rover {:x 4 :y 4 :heading "E"} "B") => {:x 3 :y 4 :heading "E"})
  (fact "move BackForward to South"
        (move-rover {:x 4 :y 4 :heading "S"} "B") => {:x 4 :y 5 :heading "S"})
  (fact "move BackForward to West"
        (move-rover {:x 4 :y 4 :heading "W"} "B") => {:x 5 :y 4 :heading "W"})
  (fact "move BackForward to West"
        (move-rover {:x 4 :y 4 :heading "N"} "RFLFLFFBLFFRRRF") => {:x 3 :y 3 :heading "W"})

)