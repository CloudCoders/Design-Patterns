package oop.Flyweight

import java.awt.Point

class Admiral : Soldier {
  companion object {
    val TYPE = 1
  }
  init {
      Flyweitght.objectInstances++
  }

  val attack = 6
  val salary = 23000
  override fun attack(currentPosition: Point, attackPosition: Point) {
    currentPosition.move(attackPosition.x, attackPosition.y)
  }

}
