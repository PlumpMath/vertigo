(defproject vertigo "0.1.3"
  :description "peering down into the machine"
  :license {:name "MIT Public License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[potemkin "0.3.11"]
                 [primitive-math "0.1.4"]
                 [clj-tuple "0.1.7"]
                 [byte-streams "0.2.0-alpha7"]
                 [riddley "0.1.9"]]
  :profiles {:dev {:dependencies [[criterium "0.4.3"]
                                  [org.clojure/clojure "1.5.1"]
                                  [codox-md "0.2.0" :exclusions [org.clojure/clojure]]]}
             :benchmark {:jvm-opts ["-Dvertigo.unsafe"]}}
  :plugins [[codox "0.6.4"]]
  :codox {:writer codox-md.writer/write-docs
          :exclude [vertigo.primitives]}
  :global-vars {*warn-on-reflection* true}
  :test-selectors {:default #(not (some #{:benchmark}
                                    (cons (:tag %) (keys %))))
                   :benchmark :benchmark
                   :all (constantly true)}
  :aliases {"benchmark" ["with-profile" "dev,benchmark" "test" ":benchmark"]}
  :jvm-opts ^:replace ["-server"])
