package io.github.awwsmm.zepto

object Main extends App {

  private val commands = Set(
    Command.Echo,
    Command.Ohce,
    Command.Quit,
    Command.help(Set(Command.Echo, Command.Ohce, Command.Quit))
  )

  new Terminal(commands).run()

}
