(ns leiningen.html2md
  (:use [html-to-md-bridge.core]))

(defn ^:no-project-needed html2md
  "Converts html to md"
  [_ & files]
  (if (not-empty files)
    (html-files->md files)
    (println
      "Usage:\n"
      "lein html2md $files\n"
      "Example:\n"
      "lein html2md src/some.html root.html\n"
      "It will produce 2 files: \n"
      " - src/some.md\n"
      " - root.md")))
