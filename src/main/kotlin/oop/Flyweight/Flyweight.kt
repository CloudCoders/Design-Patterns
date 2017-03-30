package oop.Flyweight

import java.awt.Point
class Flyweight{
  companion object{
    var objectInstances = 0
  }
}
fun main(args: Array<String>) {
  val soldiers = listOf(
    SoldierClient(Admiral.TYPE),
    SoldierClient(Admiral.TYPE),
    SoldierClient(Captain.TYPE),
    SoldierClient(Captain.TYPE),
    SoldierClient(Admiral.TYPE),
    SoldierClient(Admiral.TYPE)
  )
  soldiers[0].attack(Point(1,2))
  soldiers[1].attack(Point(10,12))
  soldiers[2].attack(Point(9,5))
  soldiers[3].attack(Point(11,7))
  soldiers[4].attack(Point(21,3))

  System.out.println(Flyweight.objectInstances)

}
