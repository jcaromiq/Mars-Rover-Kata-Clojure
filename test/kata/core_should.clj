(ns kata.core_should
  (:require [midje.sweet :refer :all]
            [kata.core :refer :all]))

(facts
  "Allow Mars Rover to rotate to left from"
  (fact "North"
        (move-rover {:x 0 :y 0 :d "N"} "L") => {:x 0 :y 0 :d "E"})
  (fact "West"
        (move-rover {:x 0 :y 0 :d "W"} "L") => {:x 0 :y 0 :d "N"})
  (fact "South"
        (move-rover {:x 0 :y 0 :d "S"} "L") => {:x 0 :y 0 :d "W"})
  (fact "East"
        (move-rover {:x 0 :y 0 :d "E"} "L") => {:x 0 :y 0 :d "S"}))

(facts
  "Allow Mars Rover to rotate to right from"
  (fact "North"
        (move-rover {:x 0 :y 0 :d "N"} "R") => {:x 0 :y 0 :d "W"})
  (fact "West"
        (move-rover {:x 0 :y 0 :d "W"} "R") => {:x 0 :y 0 :d "S"})
  (fact "South"
        (move-rover {:x 0 :y 0 :d "S"} "R") => {:x 0 :y 0 :d "E"})
  (fact "East"
        (move-rover {:x 0 :y 0 :d "E"} "R") => {:x 0 :y 0 :d "N"})
  (fact "East with double rotation"
        (move-rover {:x 0 :y 0 :d "S"} "RR") => {:x 0 :y 0 :d "N"}))

(facts
  "Allow Mars Rover to rotate on itself"
  (fact "same direction"
        (move-rover {:x 0 :y 0 :d "S"} "RR") => {:x 0 :y 0 :d "N"})
  (fact "with different directions"
        (move-rover {:x 0 :y 0 :d "N"} "RRLRLRL") => {:x 0 :y 0 :d "W"})
  (fact "returning to initial position"
        (move-rover {:x 0 :y 0 :d "S"} "RL") => {:x 0 :y 0 :d "S"}))

(facts
  "Allow Mars Rover to"
  (fact "stay in the same position if no commands getting"
        (move-rover {:x 0 :y 0 :d "N"} "") => {:x 0 :y 0 :d "N"})
  (fact "move Forward to North"
        (move-rover {:x 0 :y 0 :d "N"} "F") => {:x 0 :y 1 :d "N"})
  (fact "move Forward to East"
        (move-rover {:x 0 :y 0 :d "E"} "F") => {:x 1 :y 0 :d "E"})
  (fact "move Forward to South"
        (move-rover {:x 0 :y 4 :d "S"} "F") => {:x 0 :y 3 :d "S"})
  (fact "move Forward to West"
        (move-rover {:x 1 :y 0 :d "W"} "F") => {:x 0 :y 0 :d "W"})
  (fact "move BackForward to North"
        (move-rover {:x 4 :y 4 :d "N"} "B") => {:x 4 :y 3 :d "N"})
  (fact "move BackForward to East"
        (move-rover {:x 4 :y 4 :d "E"} "B") => {:x 3 :y 4 :d "E"})
  (fact "move BackForward to South"
        (move-rover {:x 4 :y 4 :d "S"} "B") => {:x 4 :y 5 :d "S"})
  (fact "move BackForward to West"
        (move-rover {:x 4 :y 4 :d "W"} "B") => {:x 5 :y 4 :d "W"})
  (fact "move BackForward to West"
        (move-rover {:x 4 :y 4 :d "N"} "RFLFLFFBLFFRRRF") => {:x 3 :y 3 :d "W"})
  (fact "ignore unsupported commands"
        (move-rover {:x 4 :y 4 :d "W"} "QWE") => {:x 4 :y 4 :d "W"})
  (fact "wrapping from one edge of the grid to another"
        (move-rover {:x 19 :y 0 :d "E"} "F") => {:x 0 :y 0 :d "E"}
        (move-rover {:x 0 :y 19 :d "N"} "F") => {:x 0 :y 0 :d "N"})


  )