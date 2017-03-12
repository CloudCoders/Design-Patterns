package Command.commands

import Command.base.Command

class ExitCommand : Command {
  companion object {
    val EXIT = "0"
  }

  override fun matches(command: String): Boolean = command == EXIT

  override fun execute() {
    println("\n\nVenga chavales un saludo adios \\__(o_o)__/")
  }

}
