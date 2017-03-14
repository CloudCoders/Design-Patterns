package Command.base

import Decorator.littlekai.base.Noodles
import Decorator.littlekai.base.SauceDecorator
import Decorator.littlekai.ingredients.Chicken
import Decorator.littlekai.ingredients.Peanuts
import Decorator.littlekai.ingredients.Pork
import Decorator.littlekai.ingredients.Tuna
import Decorator.littlekai.noodles.EggNoodles
import Decorator.littlekai.noodles.UdonNoodles
import Decorator.littlekai.noodles.WheatNoodles
import Decorator.littlekai.sauces.BittersweetSauce
import Decorator.littlekai.sauces.RedPepperSauce
import Decorator.littlekai.sauces.SateSauce
import Decorator.littlekai.sauces.TeriyakiSauce
import Factory.base.NoodlesFactory
import java.util.*

class Cart(private val scanner: Scanner) {

  private lateinit var noodles: Noodles

  fun chooseNoodles() {
    var noodlesChoice: Int = 0
    while (!(1..3).contains(noodlesChoice)) {
      println("> Choose your noodles!\n")
      println("1> EggNoodles:    3.75 $")
      println("2> UdonNoodles:   4.00 $")
      println("3> WheatNoodles:  3.50 $")
      print("> ")
      noodlesChoice = scanner.nextInt()
    }
    println()

    val noodlesFactory = NoodlesFactory()
    noodles = noodlesFactory.getNoodles(noodlesChoice)
  }

  fun chooseIngredient() {
    var ingredientChoice: Int = -1
    while (!(1..4).contains(ingredientChoice)) {
      println("> Choose your ingredient!\n")
      println("1> Chicken: 3.50 $")
      println("2> Peanuts: 2.50 $")
      println("3> Pork:    4.00 $")
      println("4> Tuna:    2.75 $\n")
      print("> ")
      ingredientChoice = scanner.nextInt()
    }
    println()

    when (ingredientChoice) {
      1 -> noodles = Chicken(noodles)
      2 -> noodles = Peanuts(noodles)
      3 -> noodles = Pork(noodles)
      else -> noodles = Tuna(noodles)
    }
  }

  fun chooseSauce() {
    var sauceChoice: Int = -1
    while (!(1..4).contains(sauceChoice)) {
      println("> Choose your sauce!\n")
      println("1> Bittersweet Sauce: 1 out of 4 spiciness")
      println("2> Red Pepper Sauce:  4 out of 4 spiciness")
      println("3> Sate Sauce:        2 out of 4 spiciness")
      println("4> Teriyaki Sauce:    0 out of 4 spiciness\n")
      print("> ")
      sauceChoice = scanner.nextInt()
    }
    println()

    when (sauceChoice) {
      1 -> noodles = BittersweetSauce(noodles)
      2 -> noodles = RedPepperSauce(noodles)
      3 -> noodles = SateSauce(noodles)
      else -> noodles = TeriyakiSauce(noodles)
    }
  }

  fun showPrice() {
    println("> Your order is: ${noodles.calculateCost()} $")
    if (noodles is SauceDecorator) {
      println("> Spiciness is: ${(noodles as SauceDecorator).SPICINESS} out of 4")
    } else {
      println("> Without sauce")
    }
    println()
  }
}
