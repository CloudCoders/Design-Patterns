package oop.Decorator.ingredients

import oop.Decorator.base.IngredientDecorator
import oop.Decorator.base.Noodles


class Pork(noodles: Noodles) : IngredientDecorator(noodles) {
  override val COST: Double = 4.00
}
