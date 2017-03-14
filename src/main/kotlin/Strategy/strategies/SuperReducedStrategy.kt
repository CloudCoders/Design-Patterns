package Strategy.strategies

import Strategy.base.IvaStrategy

class SuperReducedStrategy : IvaStrategy {

  override fun applyIva(cost: Double): Double {
    return cost + cost * 0.04
  }

}
