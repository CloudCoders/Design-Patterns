package Decorator.littlekai.noodles

import Decorator.littlekai.base.Noodles

class WheatNoodles : Noodles {
  val COST : Double = 3.50

  override fun calculateCost(): Double = this.COST
}
