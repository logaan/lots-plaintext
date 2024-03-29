(defproject lots-plaintext "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]
                 [reagent "0.4.2"]
                 [datascript "0.4.0"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild {:builds [{:id "lots-plaintext"
                        :source-paths ["src"]
                        :compiler {:preamble  ["reagent/react.js"]
                                   :externs ["datascript/externs.js"]
                                   :output-to "lots_plaintext.js"
                                   :output-dir "out"
                                   :optimizations :none
                                   :source-map true}}]})
