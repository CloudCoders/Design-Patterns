package oop.Decorator.sauces

import oop.Decorator.base.Noodles
import oop.Decorator.base.SauceDecorator

class BittersweetSauce(noodles: Noodles) : SauceDecorator(noodles) {
  override val SPICINESS: Int = 1
}


