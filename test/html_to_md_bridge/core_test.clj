(ns html-to-md-bridge.core-test
  (:import (java.io File)
           (java.net URL))
  (:require [clojure.test :refer :all]
            [html-to-md-bridge.core :refer :all]
            [clojure.java.io :as io]))

(deftest convert-files
  (testing "creation and convertation of files"
    (let [html-file-path (.getFile ^URL (io/resource "html_to_md_bridge/test.html"))]
      (html-files->md [html-file-path])
      (let [md-file (File. (.toURI (io/resource "html_to_md_bridge/test.md")))]
        (is (.exists md-file))
        (is (.delete md-file))))))
