package io.github.awwsmm.zepto

/**
 * Represents an action that the `Terminal` can perform.
 *
 * All input after the end of the `name` of the command (including all whitespace, even
 * leading and trailing whitespace) is passed as a single argument to the `action`, which
 * operates on the input and returns an optional output `String`.
 *
 * @param name name of the command; will appear in '''help''' output
 * @param help description of the command; will appear in '''help''' output
 * @param action the function which is applied to the input
 */
case class Command (name: String, help: String, action: Option[String] => Option[String]) {
  import Command._
  assert(wordRegex.matches(name), regexError)
}

// TODO add pipe operator | to chain commands

object Command {
  private val wordRegex = """[a-zA-Z][a-zA-Z0-9_]*""".r
  private val regexError = "Command name must begin with a letter and contain only alphanumeric characters and underscores"

  val Echo: Command = Command("echo", "echoes text", identity)
  val Ohce: Command = Command("ohce", "reverses and echoes text", _.map(_.trim.reverse))
  val Quit: Command = Command("quit", "quits the terminal", _ => None)

  def help(commands: Set[Command]): Command = {
    val command = Command("help", "prints this help text", _ => helpFormat(commands))
    command.copy(action = _ => helpFormat(commands + command))
  }

  val defaultHelpFormat: Command => String = command => s"${command.name} => ${command.help}"

  def helpFormat(commands: Set[Command], format: Command => String = defaultHelpFormat): Option[String] =
    Some(commands.toList.sortBy(_.name).map(format).mkString("\n"))

}