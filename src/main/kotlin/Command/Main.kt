package Command

import Command.base.Cart
import Command.base.Processor
import Command.cart.CmdCart
import Command.commands.ChooseNoodlesCommand
import java.util.*

fun main (args : Array<String>) {

  val scanner = Scanner(System.`in`)
  val cart : Cart = CmdCart(scanner)
  val kitchen : Processor = Processor(cart)

  println("##############")
  println("  Little Kai  ")
  println("##############\n")

  kitchen.process(ChooseNoodlesCommand.CHOOSE_NOODLES).execute()

  var commandChoice = -1
  do {
    println("> Available commands")
    println("1> Choose noodles")
    println("2> Choose ingredient")
    println("3> Choose sauce")
    println("4> Show price")
    println("0> Exit")

    print("> ")
    commandChoice = scanner.nextInt()

    if ((1..4).contains(commandChoice)) {
      kitchen.process("$commandChoice").execute()
    }

  } while (commandChoice != 0)

}
