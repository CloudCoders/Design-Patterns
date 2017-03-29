package oop.Command.commands

import oop.Command.base.Cart
import oop.Command.base.Command


class ShowPriceCommand(val cart : Cart) : Command {
  companion object {
    val SHOW_PRICE : String = "4"
  }

  override fun matches(command: String): Boolean = command == SHOW_PRICE

  override fun execute() {
    cart.showPrice()
  }
}
