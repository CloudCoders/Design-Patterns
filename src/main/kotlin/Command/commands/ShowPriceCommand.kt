package Command.commands

import Command.base.Cart
import Command.base.Command


class ShowPriceCommand(val cart : Cart) : Command {
  companion object {
    val SHOW_PRICE : String = "4"
  }

  override fun matches(command: String): Boolean = command.equals(SHOW_PRICE)

  override fun execute() {
    cart.showPrice()
  }
}
