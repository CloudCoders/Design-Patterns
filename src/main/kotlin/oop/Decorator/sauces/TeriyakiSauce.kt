package oop.Decorator.sauces

import oop.Decorator.base.Noodles
import oop.Decorator.base.SauceDecorator


class TeriyakiSauce(noodles: Noodles) : SauceDecorator(noodles) {
  override val SPICINESS: Int = 0
}
