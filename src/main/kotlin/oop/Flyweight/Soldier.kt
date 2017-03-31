package oop.Flyweight

data class Point(val x: Int, val y: Int)

data class Soldier(val name: String)

class SoldierFactory(private val soldiers: MutableList<Soldier> = mutableListOf()) {

  fun getSoldier(name: String): Soldier {
    if (!soldiers.map { it.name }.contains(name)) {
      soldiers.add(Soldier(name))
    }

    return soldiers.filter { it.name == name }.first()
  }

}

data class Attack(val soldier: Soldier, val point: Point) {
  override fun toString(): String {
    return "$soldier attack ${point.x},${point.y} point"
  }
}

class SoldierClient(private val soldierFactory: SoldierFactory,
                    val attacks : MutableList<Attack> = mutableListOf<Attack>()) {

  fun attack(soldierName: String, point: Point) {
    val soldier = soldierFactory.getSoldier(soldierName)
    attacks.add(Attack(soldier, point))
  }

}
