(ns lots-plaintext.core
  (:require [reagent.core :as ra]
            [datascript :as ds]))

(enable-console-print!)

(def schema {:aka {:db/cardinality :db.cardinality/many}})
(def conn (ds/create-conn schema))

(ds/transact! conn [ { :db/id -1
                        :name  "Maksim"
                        :age   45
                        :aka   ["Maks Otto von Stirlitz", "Jack Ryan"] } ])



(defn child [[name age]]
  [:p "Hi, I am " name " I was born " age " years ago."])

(defn childcaller []
  (let [data (ds/q '[:find ?n ?a
                    :where [?e :aka "Maks Otto von Stirlitz"]
                    [?e :name ?n]
                    [?e :age  ?a]]
                  @conn)]
    [child (first data)]))

(defn mountit  []
  (ra/render-component [childcaller]
                       (.-body js/document)))

(mountit)

