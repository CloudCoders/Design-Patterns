package Command.base

import Command.commands.ChooseIngredientCommand
import Command.commands.ChooseNoodlesCommand
import Command.commands.ChooseSauceCommand
import Command.commands.ShowPriceCommand

class Processor(val cart: Cart) {

  fun process(command : String) : Command {
    when (command) {
      ChooseNoodlesCommand.CHOOSE_NOODLES -> return ChooseNoodlesCommand(cart)
      ChooseIngredientCommand.CHOOSE_INGREDIENT -> return ChooseIngredientCommand(cart)
      ChooseSauceCommand.CHOOSE_SAUCE -> return ChooseSauceCommand(cart)
      else -> return ShowPriceCommand(cart)
    }
  }

}
