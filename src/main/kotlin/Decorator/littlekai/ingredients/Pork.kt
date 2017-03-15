package Decorator.littlekai.ingredients

import Decorator.littlekai.base.IngredientDecorator
import Decorator.littlekai.base.Noodles


class Pork(noodles: Noodles) : IngredientDecorator(noodles) {
  private val COST: Double = 4.00

  override fun calculateTotalCost(): Double {
    return calculateCost() + COST
  }
}
