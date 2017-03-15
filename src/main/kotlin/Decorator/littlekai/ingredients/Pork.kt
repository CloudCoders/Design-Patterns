package Decorator.littlekai.ingredients

import Decorator.littlekai.base.IngredientDecorator
import Decorator.littlekai.base.Noodles


class Pork(noodles: Noodles, val COST: Double = 4.00): IngredientDecorator(noodles) {
  override fun calculateTotalCost(): Double = super.calculateTotalCost() + COST
}
