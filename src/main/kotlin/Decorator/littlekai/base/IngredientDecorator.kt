package Decorator.littlekai.base

abstract class IngredientDecorator (protected val noodles: Noodles) : Noodles {
  protected abstract val COST : Double

  override fun calculateCost(): Double = noodles.calculateCost() + this.COST
}
