package Decorator.littlekai.noodles

import Decorator.littlekai.base.Noodles

class UdonNoodles : Noodles {
  private val COST : Double = 4.00

  override fun calculateCost(): Double = this.COST
}