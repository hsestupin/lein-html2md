(ns html-to-md-bridge.core
  (:import (java.io File FileWriter))
  (:require [html-to-md.core :as html2md]
            [clojure.java.io :as io]))

(defn md-file-name [^String file-path]
  (if (.endsWith (.toLowerCase file-path) ".html")
    (str (.substring file-path 0 (- (.length file-path) 5)) ".md")
    (str file-path ".md")))

(defn ^File force-create-new-file [file-path]
  (let [^File file (File. file-path)]
    (when (.exists file)
      (.delete file))
    (.createNewFile file)
    (println (.getAbsolutePath file) "was created")
    file))

(defn html-file->md [^String file-path]
  (let [^File html-file (File. file-path)]
    (with-open [input (io/reader html-file)
                output (FileWriter. (force-create-new-file (md-file-name file-path)))]
      (html2md/html-to-md input output))))

(defn html-files->md
  "For each html file create its md represatation at the same directory"
  [file-paths]
  (doall (map html-file->md file-paths)))
