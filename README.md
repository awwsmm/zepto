# zepto

A teeny, tiny, customisable, dependency-free shell for interactive Scala applications.

## Usage

Add **zepto** to your `build.sbt` `libraryDependencies` with

```sbt
"io.github.awwsmm" %% "zepto" % "0.4.0"
```

Then, add a `Terminal` to your project like

```scala
import io.github.awwsmm.zepto.{Command, Terminal}

object Main extends App {
  import Command._

  // example custom command
  val hello = Command("hello", "says hello", _ => println("Hello, World!"))

  // example custom prompt
  val prompt = "\nmyshell$ "

  // register all the commands
  val commands = Set(Echo, Ohce, Quit, hello, help(Set(Echo, Ohce, Quit, hello)))

  // create the terminal with the custom commands and prompt
  val terminal = Terminal(commands, prompt)

  // run the terminal until the user `quit` s
  terminal.run()
}
```

Running with `sbt` gives output like

```shell
$ sbt
...
[info] started sbt server
sbt:example> run
...
[info] running org.example

myshell$ hello
Hello, World!

myshell$ echo My name is Zepto
My name is Zepto

myshell$
```

## Example Shell

You can also clone this repository and run the **zepto** example shell from the command line with `sbt`

```sbt
$ sbt run
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

zepto> 
```