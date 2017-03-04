package Decorator.littlekai

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
import java.util.*

val scanner = Scanner(System.`in`)

fun main(args : Array<String>) {

  println("##############")
  println("  Little Kai  ")
  println("##############\n")

  val baseNoodles : Noodles = getBaseNoodles(chooseNoodles())
  val noodlesWithIngredient : Noodles = getIngredient(baseNoodles, chooseIngredient())
  val noodlesWithIngredientAndSouce : Noodles = getSauce(noodlesWithIngredient, chooseSauce())

  println("> Your order is: ${noodlesWithIngredientAndSouce.calculateCost()} $")
  if (noodlesWithIngredientAndSouce is SauceDecorator) {
    println("> Spiciness is: ${noodlesWithIngredientAndSouce.SPICINESS} out of 4")
  } else {
    println("> Without sauce")
  }

  println("> Enjoy your noodles! :D")
}

fun chooseNoodles() : Int {
  var noodlesChoice : Int = 0
  while (!(1..3).contains(noodlesChoice)) {
    println("> Choose your noodles!\n")
    println("1> EggNoodles:    3.75 $")
    println("2> UdonNoodles:   4.00 $")
    println("3> WheatNoodles:  3.50 $")
    print("> ")
    noodlesChoice = scanner.nextInt()
  }
  println()
  return noodlesChoice
}

fun getBaseNoodles(choice: Int) : Noodles {
  when (choice) {
    1 -> return EggNoodles()
    2 -> return UdonNoodles()
    else -> return WheatNoodles()
  }
}

fun chooseIngredient() : Int {
  var ingredientChoice : Int = -1
  while (ingredientChoice != 0 && !(1..4).contains(ingredientChoice)) {
    println("> Choose your ingredient!\n")
    println("1> Chicken: 3.50 $")
    println("2> Peanuts: 2.50 $")
    println("3> Pork:    4.00 $")
    println("4> Tuna:    2.75 $\n")
    println("0> No more ingredients")
    print("> ")
    ingredientChoice = scanner.nextInt()
  }
  println()
  return ingredientChoice
}

fun getIngredient(noodles: Noodles, choice: Int) : Noodles {
  println("> Your cart is: ${noodles.calculateCost()} $")
  when (choice) {
    1 -> return getIngredient(Chicken(noodles), chooseIngredient())
    2 -> return getIngredient(Peanuts(noodles), chooseIngredient())
    3 -> return getIngredient(Pork(noodles), chooseIngredient())
    4 -> return getIngredient(Tuna(noodles), chooseIngredient())
    else -> return noodles
  }
}
fun chooseSauce() : Int {
  var sauceChoice : Int = -1
  while (sauceChoice != 0 && !(1..4).contains(sauceChoice)) {
    println("> Choose your sauce!\n")
    println("1> Bittersweet Sauce: 1 out of 4 spiciness")
    println("2> Red Pepper Sauce:  4 out of 4 spiciness")
    println("3> Sate Sauce:        2 out of 4 spiciness")
    println("4> Teriyaki Sauce:    0 out of 4 spiciness\n")
    println("0> No sauce")
    print("> ")
    sauceChoice = scanner.nextInt()
  }
  println()
  return sauceChoice
}

fun getSauce(noodles: Noodles, choice: Int) : Noodles {
  when (choice) {
    1 -> return BittersweetSauce(noodles)
    2 -> return RedPepperSauce(noodles)
    3 -> return SateSauce(noodles)
    4 -> return TeriyakiSauce(noodles)
    else -> return noodles
  }
}
