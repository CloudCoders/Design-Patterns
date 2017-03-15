package Decorator.littlekai.noodles

import Decorator.littlekai.base.Noodles

class EggNoodles(val COST: Double = 3.75): Noodles {
  override fun calculateCost(): Double = COST
  override fun calculateTotalCost(): Double = COST
}
