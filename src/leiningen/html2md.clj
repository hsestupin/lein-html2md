(ns leiningen.html2md
  (:use [html-to-md-bridge.core]))

(defn html2md
  "Converts html to md"
  [_ & [first-arg rest-args]]
  (if (= first-arg "html2md")
    (html-files->md rest-args)
    (println
      "Usage:\n"
      "lein html2md $files\n"
      "Example:\n"
      "lein html2md src/some.html root.html\n"
      "It will produce 2 files: \n"
      " - src/some.md\n"
      " - root.md")))
