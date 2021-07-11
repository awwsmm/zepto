package io.github.awwsmm.zepto

case class Command (name: String, help: String, action: String => Unit)

object Command {

  val Echo: Command = Command("echo", "echoes text", println)
  val Ohce: Command = Command("ohce", "reverses and echoes text", string => println(string.reverse))
  val Quit: Command = Command("quit", "quits zepto", _ => ())

  def help(commands: Set[Command]): Command = {
    val command = Command("help", "prints this help text", _ => printHelp(commands))
    command.copy(action = _ => printHelp(commands + command))
  }

  val defaultHelpFormat: Command => String = command => s"${command.name} => ${command.help}"

  def printHelp(commands: Set[Command], format: Command => String = defaultHelpFormat): Unit =
    commands.toList.sortBy(_.name).foreach(command => println(format(command)))

}