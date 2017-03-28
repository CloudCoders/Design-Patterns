package oop.Command.commands

import oop.Command.base.Cart
import oop.Command.base.Command


class ChooseSauceCommand(val cart : Cart) : Command {
  companion object {
    val CHOOSE_SAUCE : String = "3"
  }

  override fun matches(command: String): Boolean = command == CHOOSE_SAUCE

  override fun execute() {
    cart.chooseSauce()
  }
}
