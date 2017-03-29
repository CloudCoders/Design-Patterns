package oop.Decorator.noodles

import oop.Decorator.base.Noodles

class UdonNoodles : Noodles {
  private val COST : Double = 4.00

  override fun calculateCost(): Double = this.COST
}
