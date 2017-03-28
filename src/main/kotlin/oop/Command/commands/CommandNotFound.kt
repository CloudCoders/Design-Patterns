package oop.Command.commands

import oop.Command.base.Command

class CommandNotFound : Command {

  override fun matches(command: String): Boolean = true

  override fun execute() {
    println("\n\nI do not recognize that command, hdp!!\n\n")
  }

}
