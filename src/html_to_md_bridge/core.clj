(ns html-to-md-bridge.core
  (:import (java.io File))
  (:require [html-to-md.core :as html2md]
            [clojure.java.io :as io]))

(defn md-file-name [^String file-path]
  (if (.endsWith (.toLowerCase file-path) ".html")
    (str (.substring file-path 0 (- (.length file-path) 5)) ".md")
    (str file-path ".md")))

(defn html-file->md [^String file-path]
  (let [html-file (File. file-path)]
    (with-open [input (io/reader html-file)
                output (io/writer (md-file-name file-path))]
      (html2md/html-to-md input output))))

(defn html-files->md
  "For each html file create its md represatation at the same directory"
  [file-paths]
  (doall (map html-file->md file-paths)))
