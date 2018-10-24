package oop.Flyweight

data class Point(val x: Int, val y: Int)

data class Soldier(val name: String)

class Flyweight<A>(val values: MutableSet<A> = mutableSetOf()) {

  fun getFactory(value: A): A {
    values.add(value)
    return values.filter { it == value }.first()
  }

}

class SoldierFactory(val soldiers: Flyweight<Soldier> = Flyweight<Soldier>(),
                     val points: Flyweight<Point> = Flyweight<Point>()) {

  constructor(soldiers: List<Soldier> = emptyList(), points: List<Point> = emptyList())
    : this(Flyweight(soldiers.toMutableSet()), Flyweight(points.toMutableSet()))

  fun getSoldier(name: String): Soldier {
    return soldiers.getFactory(Soldier(name))
  }

  fun getPoint(x: Int, y: Int): Point {
    return points.getFactory(Point(x, y))
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
