package Decorator.littlekai.ingredients

import Decorator.littlekai.base.IngredientDecorator
import Decorator.littlekai.base.Noodles


class Chicken(noodles: Noodles, val COST: Double = 3.50): IngredientDecorator(noodles) {
  override fun calculateTotalCost(): Double = super.calculateTotalCost() + COST
}
