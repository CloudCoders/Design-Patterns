package Decorator.littlekai.base

abstract class SauceDecorator(private val noodles: Noodles) : Noodles by noodles {
  abstract val SPICINESS: Int
}
