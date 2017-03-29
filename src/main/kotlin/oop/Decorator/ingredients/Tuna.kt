package oop.Decorator.ingredients

import oop.Decorator.base.IngredientDecorator
import oop.Decorator.base.Noodles


class Tuna(noodles: Noodles) : IngredientDecorator(noodles) {
  override val COST: Double = 2.75
}
