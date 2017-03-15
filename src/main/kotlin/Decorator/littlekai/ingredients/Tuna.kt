package Decorator.littlekai.ingredients

import Decorator.littlekai.base.IngredientDecorator
import Decorator.littlekai.base.Noodles


class Tuna(noodles: Noodles, val COST: Double = 2.75): IngredientDecorator(noodles) {
  override fun calculateTotalCost(): Double = super.calculateTotalCost() + COST
}
