package oop.Command.commands

import oop.Command.base.Cart
import oop.Command.base.Command

class ChooseNoodlesCommand(val cart : Cart) : Command {
  companion object {
    val CHOOSE_NOODLES : String = "1"
  }

  override fun matches(command: String): Boolean = command == CHOOSE_NOODLES

  override fun execute() {
    cart.chooseNoodles()
  }

}


