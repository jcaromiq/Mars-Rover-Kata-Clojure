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
        (move-rover {:x 0 :y 0 :heading "E"} "R") => {:x 0 :y 0 :heading "N"}))
  

(facts
  "Allow Mars Rover to "
  (fact "Stays in the same position if no commands getting"
        (move-rover {:x 0 :y 0 :heading "N"} "") => {:x 0 :y 0 :heading "N"})
  ;(fact "move Forward"
  ;  (move-rover {:x 0 :y 0 :heading "N"} "F") => {:x 0 :y 1 :heading "N"})
  )