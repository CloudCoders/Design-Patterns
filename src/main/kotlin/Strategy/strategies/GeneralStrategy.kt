package Strategy.strategies

import Strategy.base.IvaStrategy

class GeneralStrategy : IvaStrategy {

  override fun applyIva(cost: Double): Double {
    return cost + cost * 0.21
  }

}
