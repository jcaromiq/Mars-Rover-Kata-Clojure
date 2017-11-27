(ns kata.core_should
  (:require [midje.sweet :refer :all]
            [kata.core :refer :all]))

(facts
  "Mars Rover Kata"
  (fact
    "Stays in the same position if no commands getting"
    (move-rover {:x 0 :y 0 :facing "N"} "") => {:x 0 :y 0 :facing "N"}))