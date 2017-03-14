package strategy

class ReducedStrategy : IvaStrategy {

  override fun applyIva(cost: Double): Double {
    return cost + cost * 0.10
  }

}
