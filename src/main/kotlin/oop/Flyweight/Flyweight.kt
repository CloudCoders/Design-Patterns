package oop.Flyweight

fun main(args: Array<String>) {
  val soldiers = mutableListOf(
    Soldier("Pedro"),
    Soldier("Ryan"),
    Soldier("Forest")
  )

  val soldiersAttacks = SoldierClient(SoldierFactory(soldiers))
  soldiersAttacks.attack("Pedro", 1, 2)
  soldiersAttacks.attack("Ryan", 10, 12)
  soldiersAttacks.attack("Ryan", 13, 2)
  soldiersAttacks.attack("Forest", 1, 2)
  soldiersAttacks.attack("Pedro", 1, 2)
  soldiersAttacks.attack("Pedro", 10, 12)
  soldiersAttacks.attack("Pedro", 44, 5)

  soldiersAttacks.attacks.forEach(::println)
}
