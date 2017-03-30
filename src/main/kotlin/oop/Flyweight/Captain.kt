package oop.Flyweight

import java.awt.Point

class Captain : Soldier {
  companion object {
    val TYPE = 2
  }
  init {
      Flyweitght.objectInstances++
  }

  val attack = 10
  val salary = 10000
  override fun attack(currentPosition: Point, attackPosition: Point) {
    currentPosition.move(attackPosition.x, attackPosition.y)
  }

}
