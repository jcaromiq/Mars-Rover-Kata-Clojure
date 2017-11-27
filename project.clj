(defproject mars-rover-kata-clojure "0.1.0-SNAPSHOT"
  :description "Mars Rover Kata in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.3"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev     {:plugins      [[lein-midje "3.1.3"] [lein-cloverage "1.0.9"]]
                       :dependencies [[midje "1.6.3"]]}}
  )
