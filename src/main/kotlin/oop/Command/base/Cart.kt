package oop.Command.base

import oop.Decorator.base.Noodles
import oop.Decorator.base.SauceDecorator
import oop.Decorator.ingredients.Chicken
import oop.Decorator.ingredients.Peanuts
import oop.Decorator.ingredients.Pork
import oop.Decorator.ingredients.Tuna
import oop.Decorator.sauces.BittersweetSauce
import oop.Decorator.sauces.RedPepperSauce
import oop.Decorator.sauces.SateSauce
import oop.Decorator.sauces.TeriyakiSauce
import oop.Factory.NoodlesFactory
import oop.Strategy.strategies.GeneralStrategy
import oop.Strategy.strategies.ReducedStrategy
import oop.Strategy.strategies.SuperReducedStrategy
import java.util.*

open class Cart(private val scanner: Scanner,
  private var ivaStrategy: (Double) -> Double = GeneralStrategy) {


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

  open fun chooseIngredient() {
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

  fun chooseStrategy(){
    var sauceChoice: Int = -1
    while (!(1..3).contains(sauceChoice)) {
      println("> Choose your IVA !\n")
      println("1> General IVA 21%")
      println("2> Reduced IVA 10%")
      println("3> Super Reduced IVA 4%")
      print("> ")
      sauceChoice = scanner.nextInt()
    }
    println()
    println()

    when (sauceChoice) {
      1 -> ivaStrategy = GeneralStrategy
      2 -> ivaStrategy = ReducedStrategy
      3 -> ivaStrategy = SuperReducedStrategy
      else -> ivaStrategy = GeneralStrategy
    }
  }

  fun showPrice() {
    chooseStrategy()

    println("> Your order is: ${ivaStrategy(noodles.calculateCost())} $")
    if (noodles is SauceDecorator) {
      println("> Spiciness is: ${(noodles as SauceDecorator).SPICINESS} out of 4")
    } else {
      println("> Without sauce")
    }
    println()
  }
}
