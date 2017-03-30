package oop.Flyweight

import java.awt.Point

class SoldierClient(private val type: Int) {
  private val soldier: Soldier = SoldierFactory.getSoldier(type)
  private val currentPosition: Point = Point()

  fun attack(attackPoint: Point){
    soldier.attack(currentPosition,attackPoint)
  }

}
