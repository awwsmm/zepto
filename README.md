# zepto

A teeny, tiny, customisable, dependency-free shell for interactive Scala applications.

## Example

Run the **zepto** example shell from the command line with `sbt`

```
$ sbt run
[info] welcome to sbt 1.5.2 (Azul Systems, Inc. Java 1.8.0_131)
...
[info] running zepto.Main

zepto> echo test
test

zepto> ohce test
tset

zepto> help
echo => echoes text
help => prints this help text
ohce => reverses and echoes text
quit => quits zepto

zepto> quit
[success] Total time: 18 s, completed 11-Jul-2021 21:57:14
```