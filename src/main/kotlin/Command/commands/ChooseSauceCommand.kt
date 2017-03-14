package Command.commands

import Command.base.Cart
import Command.base.Command


class ChooseSauceCommand(val cart : Cart) : Command {
  companion object {
    val CHOOSE_SAUCE : String = "3"
  }

  override fun matches(command: String): Boolean = command == CHOOSE_SAUCE

  override fun execute() {
    cart.chooseSauce()
  }
}
