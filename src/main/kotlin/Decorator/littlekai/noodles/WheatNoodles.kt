package Decorator.littlekai.noodles

import Decorator.littlekai.base.Noodles

class WheatNoodles(val COST: Double = 3.50): Noodles {
  override fun calculateCost(): Double = COST
  override fun calculateTotalCost(): Double = COST
}
