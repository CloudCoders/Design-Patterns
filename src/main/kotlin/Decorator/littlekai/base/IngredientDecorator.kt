package Decorator.littlekai.base

abstract class IngredientDecorator (private val noodles: Noodles) : Noodles by noodles {
  protected abstract val COST : Double

  fun calculateTotalCost(): Double = noodles.calculateCost() + COST
}
