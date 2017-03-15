package Decorator.littlekai.ingredients

import Decorator.littlekai.base.IngredientDecorator
import Decorator.littlekai.base.Noodles


class Peanuts(noodles: Noodles) : IngredientDecorator(noodles) {
  private val COST: Double = 2.50

  override fun calculateTotalCost(): Double {
    return calculateCost() + COST
  }
}
