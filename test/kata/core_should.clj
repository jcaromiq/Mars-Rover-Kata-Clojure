(ns kata.core_should
  (:require [midje.sweet :refer :all]
            [kata.core :refer :all]))

(facts
  "Mars Rover Kata"
  (fact
    "Stays in the same position if no commands getting"
    (move-rover {:x 0 :y 0 :heading "N"} "") => {:x 0 :y 0 :heading "N"})
  (fact
    "Move forward"
    (move-rover {:x 0 :y 0 :heading "N"} "F") => {:x 0 :y 1 :heading "N"})
  )