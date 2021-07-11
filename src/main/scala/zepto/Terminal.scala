package zepto

case class Terminal(commands: Set[Command], prompt: String = "\nzepto> ") {

  val commandMap: Map[String, Command] =
    commands.map(command => command.name -> command).toMap

  def run(): Unit = {
    var running = true
    while (running) {

      val line = scala.io.StdIn.readLine(prompt)
      val command :: args = line.trim.split("\\s+", 2).toList

      command match {
        case "quit" =>
          running = false

        case known if commandMap.keySet contains known =>
          commandMap(known).action(args.headOption.getOrElse(""))

        case "" => // ignore empty command

        case unknown =>
          println(s"unknown command '$unknown'")
      }
    }
  }

}
