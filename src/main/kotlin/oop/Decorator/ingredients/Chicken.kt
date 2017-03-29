package oop.Decorator.ingredients

import oop.Decorator.base.IngredientDecorator
import oop.Decorator.base.Noodles


class Chicken(noodles: Noodles) : IngredientDecorator(noodles) {
  override val COST: Double = 3.50
}
