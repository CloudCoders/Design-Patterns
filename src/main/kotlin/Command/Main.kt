package Command

import Command.base.Cart
import Command.base.Processor
import Command.commands.*
import java.util.*

private fun showCommands() {
  println("> Available commands")
  println("1> Choose noodles")
  println("2> Choose ingredient")
  println("3> Choose sauce")
  println("4> Show price")
  println("0> Exit")

  print("> ")
}

fun main(args: Array<String>) {

  val scanner = Scanner(System.`in`)
  val cart: Cart = Cart(scanner)
  var commands = listOf(
    ChooseNoodlesCommand(cart),
    ChooseSauceCommand(cart),
    ChooseIngredientCommand(cart),
    ShowPriceCommand(cart),
    ExitCommand()
  )
  val kitchen: Processor = Processor(commands, CommandNotFound())
  val initCommand = ChooseNoodlesCommand.CHOOSE_NOODLES

     ////////////////////////////////////////
    //    Above app init, below the app   //
   //          below never change        //
  ////////////////////////////////////////

  println("##############")
  println("  Little Kai  ")
  println("##############\n")

  kitchen.process(initCommand).execute()

  var commandChoice = -1
  do {
    showCommands()
    commandChoice = scanner.nextInt()

    kitchen.process("$commandChoice").execute()

  } while (commandChoice != 0)

}
