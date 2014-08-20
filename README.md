# lein-html-to-md

A Leiningen plugin to convert html files to md. 

 * Doesn't require project
 * Foe each specified html file create corresponding `*.md` one at the same directory

## Usage

Put `[lein-html2md "0.1.0"]` into the `:plugins` vector of your
`:user` profile, or if you are on Leiningen 1.x do `lein plugin install lein-html2md 0.1.0`.

Then simply call it like this:

`lein html2md some_path/your_file1.html your_file2.html` 

## License

Copyright (C) 2014 Sergey Stupin

Distributed under the Eclipse Public License, the same as Clojure.
