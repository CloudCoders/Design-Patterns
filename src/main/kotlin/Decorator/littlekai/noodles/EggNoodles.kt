package Decorator.littlekai.noodles

import Decorator.littlekai.base.Noodles

class EggNoodles : Noodles {
  val COST : Double = 3.75

  override fun calculateCost(): Double = this.COST
}
