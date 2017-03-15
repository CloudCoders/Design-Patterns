package Decorator.littlekai.base

abstract class IngredientDecorator (private val noodles: Noodles): Noodles by noodles {
  override fun calculateTotalCost(): Double = noodles.calculateTotalCost()
}
