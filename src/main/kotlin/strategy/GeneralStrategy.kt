package strategy

class GeneralStrategy : IvaStrategy {

  override fun applyIva(cost: Double): Double {
    return cost + cost * 0.21
  }

}
