package Decorator.littlekai.ingredients

import Decorator.littlekai.base.IngredientDecorator
import Decorator.littlekai.base.Noodles


class Chicken(noodles: Noodles) : IngredientDecorator(noodles) {
  override val COST: Double = 3.50
}
