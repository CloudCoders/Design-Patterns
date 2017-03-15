package Decorator.littlekai.sauces

import Decorator.littlekai.base.Noodles
import Decorator.littlekai.base.SauceDecorator

class BittersweetSauce(noodles: Noodles): SauceDecorator(noodles) {
  override val SPICINESS: Int = 1
}


