package oop.Flyweight

data class Point(val x: Int, val y: Int)

data class Soldier(val name: String)

class SoldierFactory(private val soldiers: MutableList<Soldier> = mutableListOf(),
                     private val points: MutableList<Point> = mutableListOf()) {

  fun getSoldier(name: String): Soldier {
    if (!soldiers.map { it.name }.contains(name)) {
      soldiers.add(Soldier(name))
    }

    return soldiers.filter { it.name == name }.first()
  }

  fun getPoint(x: Int, y: Int): Point {
    var point = Point(x, y)
    if (!points.contains(point)) {
      points.add(point)
    }

    return points.filter { it == point }.first()
  }

}

data class Attack(val soldier: Soldier, val point: Point) {
  override fun toString(): String {
    return "$soldier attack ${point.x},${point.y} point"
  }
}

class SoldierClient(private val soldierFactory: SoldierFactory,
                    val attacks: MutableList<Attack> = mutableListOf<Attack>()) {

  fun attack(soldierName: String, x: Int, y: Int) {
    val soldier = soldierFactory.getSoldier(soldierName)
    val point = soldierFactory.getPoint(x, y)
    attacks.add(Attack(soldier, point))
  }

}
