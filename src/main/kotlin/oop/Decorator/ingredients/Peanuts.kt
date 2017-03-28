package oop.Decorator.ingredients

import oop.Decorator.base.IngredientDecorator
import oop.Decorator.base.Noodles


class Peanuts(noodles: Noodles) : IngredientDecorator(noodles) {
  override val COST: Double = 2.50
}
