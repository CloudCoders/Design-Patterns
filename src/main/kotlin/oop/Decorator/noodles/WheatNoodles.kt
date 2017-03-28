package oop.Decorator.noodles

import oop.Decorator.base.Noodles

class WheatNoodles : Noodles {
  private val COST : Double = 3.50

  override fun calculateCost(): Double = this.COST
}
