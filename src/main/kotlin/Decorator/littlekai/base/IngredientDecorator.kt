package Decorator.littlekai.base

abstract class IngredientDecorator (private val noodles: Noodles) : Noodles by noodles {
  protected abstract val COST : Double

  override fun calculateCost(): Double = noodles.calculateCost() + this.COST
}
