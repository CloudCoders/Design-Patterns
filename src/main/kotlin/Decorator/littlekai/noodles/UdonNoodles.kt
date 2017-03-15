package Decorator.littlekai.noodles

import Decorator.littlekai.base.Noodles

class UdonNoodles(val COST: Double = 4.00): Noodles {
  override fun calculateCost(): Double = COST
  override fun calculateTotalCost(): Double = COST
}
