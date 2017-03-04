package Decorator.littlekai.base

abstract class SauceDecorator(protected val noodles: Noodles) : Noodles {
  abstract val SPICINESS : Int

  override fun calculateCost(): Double = this.noodles.calculateCost()

}
