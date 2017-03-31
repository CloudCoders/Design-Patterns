package oop.Flyweight

fun main(args: Array<String>) {
  val soldiers = mutableListOf(
    Soldier("Pedro"),
    Soldier("Ryan"),
    Soldier("Forest")
  )

  val soldiersAttacks = SoldierClient(SoldierFactory(soldiers))
  soldiersAttacks.attack("Pedro", Point(1,2))
  soldiersAttacks.attack("Ryan", Point(10,12))
  soldiersAttacks.attack("Ryan", Point(13,2))
  soldiersAttacks.attack("Forest", Point(133,233))
  soldiersAttacks.attack("Pedro", Point(1,1))
  soldiersAttacks.attack("Pedro", Point(2,2))
  soldiersAttacks.attack("Pedro", Point(44,5))

  soldiersAttacks.attacks.forEach(::println)
}
