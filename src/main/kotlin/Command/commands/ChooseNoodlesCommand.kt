package Command.commands

import Command.base.Cart
import Command.base.Command

class ChooseNoodlesCommand(val cart : Cart) : Command {
  companion object {
    val CHOOSE_NOODLES : String = "1"
  }

  override fun matches(command: String): Boolean = command.equals(CHOOSE_NOODLES)

  override fun execute() {
    cart.chooseNoodles()
  }

}


