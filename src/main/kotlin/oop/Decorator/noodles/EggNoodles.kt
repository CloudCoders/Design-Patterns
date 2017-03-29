package oop.Decorator.noodles

import oop.Decorator.base.Noodles

class EggNoodles : Noodles {
  private val COST : Double = 3.75

  override fun calculateCost(): Double = this.COST
}
