(ns lots-plaintext.core
  (:require [reagent.core :as reagent]))

(enable-console-print!)

(defn child [name]
  [:p "Hi, I am " name])

(defn childcaller []
  [child "Foo Bar"])

(defn mountit  []
  (reagent/render-component [childcaller] (.-body js/document)))

(mountit)

