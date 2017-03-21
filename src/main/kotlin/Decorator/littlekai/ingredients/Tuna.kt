package Decorator.littlekai.ingredients

import Decorator.littlekai.base.IngredientDecorator
import Decorator.littlekai.base.Noodles


class Tuna(noodles: Noodles): IngredientDecorator(noodles) {
  val COST: Double = 2.75

  override fun calculateTotalCost(): Double = super.calculateTotalCost() + COST
}
