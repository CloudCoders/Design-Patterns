package Command.commands

import Command.base.Cart
import Command.base.Command


class ChooseIngredientCommand(val cart : Cart) : Command {
  companion object {
    val CHOOSE_INGREDIENT : String = "2"
  }

  override fun matches(command: String) = command == CHOOSE_INGREDIENT

  override fun execute() {
    cart.chooseIngredient()
  }
}
