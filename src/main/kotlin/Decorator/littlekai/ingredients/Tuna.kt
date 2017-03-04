package Decorator.littlekai.ingredients

import Decorator.littlekai.base.IngredientDecorator
import Decorator.littlekai.base.Noodles


class Tuna(noodles: Noodles) : IngredientDecorator(noodles) {
  override val COST: Double = 2.75
}
