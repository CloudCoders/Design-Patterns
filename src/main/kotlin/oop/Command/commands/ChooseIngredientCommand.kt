package oop.Command.commands

import oop.Command.base.Cart
import oop.Command.base.Command


class ChooseIngredientCommand(val cart : Cart) : Command {
  companion object {
    val CHOOSE_INGREDIENT : String = "2"
  }

  override fun matches(command: String) = command == CHOOSE_INGREDIENT

  override fun execute() {
    cart.chooseIngredient()
  }
}
