package io.github.awwsmm.zepto

class Terminal(commands: Set[Command], prompt: String = "\nzepto> ") {

  private[this] val commandMap: Map[String, Command] =
    commands.map(command => command.name -> command).toMap

  def stdin(): String = scala.io.StdIn.readLine(prompt)

  def stdout(output: String): Unit = println(output)

  def run(): Unit = {
    var running = true
    while (running) {

      stdin().replaceAll("^\\s+", "").split("[^a-zA-Z0-9_]", 2) match {
        case Array(command, args @ _*) =>
          command match {
            case "quit" =>
              running = false

            case known if commandMap.keySet contains known =>
              val input = Option(args.mkString(""))
              commandMap(known).action(input) match {
                case Some(value) => stdout(value)
                case None => // do nothing
              }

            case "" => // ignore empty command

            case unknown =>
              stdout(s"unknown command $unknown")
          }
      }
    }
  }

}
