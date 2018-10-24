package oop.Flyweigth

import junit.framework.Assert.assertTrue
import oop.Flyweight.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class FlyweightPatternShould {

  @Test
  fun `Have one instance when only one type of soldier is created`() {
    val flyweight = Flyweight<Soldier>()
    val soldiersAttack = SoldierClient(SoldierFactory(flyweight))

    soldiersAttack.attack("Pedro", 1, 2)
    soldiersAttack.attack("Pedro", 2, 2)
    soldiersAttack.attack("Pedro", 2, 2)

    assertThat(flyweight.values.filter { it.name == "Pedro" }.size, `is`(1))
  }

  @Test
  fun `Have two instances when both types are created, no matter the number of soldiers`() {
    val flyweight = Flyweight<Soldier>()
    val soldierFactory = SoldierFactory(flyweight)
    (1..1000).forEach {
      soldierFactory.getSoldier("Pedro")
      soldierFactory.getSoldier("Ryan")
    }

    assertThat(flyweight.values.size, `is`(2))
  }

  @Test
  fun `Have the same main object in two instances of the same type`() {
    val soldierFactory = SoldierFactory(Flyweight<Soldier>())
    val soldierOne = soldierFactory.getSoldier("Pedro")
    val soldierTwo = soldierFactory.getSoldier("Pedro")

    assertTrue(soldierOne === soldierTwo)
  }

  @Test
  fun `Have one instance of points when only one instance of point is created`() {
    val points :Flyweight<Point> = Flyweight<Point>()
    val soldiersAttack = SoldierClient(SoldierFactory(points = points))

    soldiersAttack.attack("Pedro", 3, 3)
    soldiersAttack.attack("Forest", 3, 3)
    soldiersAttack.attack("Forest", 3, 3)

    assertThat(points.values.size, `is`(1))
  }
}
