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
    val soldiers = mutableListOf<Soldier>()
    val soldiersAttack = SoldierClient(SoldierFactory(soldiers))

    soldiersAttack.attack("Pedro", 1, 2)
    soldiersAttack.attack("Pedro", 2, 2)
    soldiersAttack.attack("Pedro", 2, 2)

    assertThat(soldiers.filter { it.name == "Pedro" }.size, `is`(1))
  }

  @Test
  fun `Have two instances when both types are created, no matter the number of soldiers`() {
    val soldiers = mutableListOf<Soldier>()
    val soldierFactory = SoldierFactory(soldiers)
    (1..1000).forEach {
      soldierFactory.getSoldier("Pedro")
      soldierFactory.getSoldier("Ryan")
    }

    assertThat(soldiers.size, `is`(2))
  }

  @Test
  fun `Have the same main object in two instances of the same type`() {
    val soldierFactory = SoldierFactory()
    val soldierOne = soldierFactory.getSoldier("Pedro")
    val soldierTwo = soldierFactory.getSoldier("Pedro")

    assertTrue(soldierOne === soldierTwo)
  }

  @Test
  fun `Have one instance of points when only one instance of point is created`() {
    val points = mutableListOf<Point>()
    val soldiersAttack = SoldierClient(SoldierFactory(points = points))

    soldiersAttack.attack("Pedro", 3, 3)
    soldiersAttack.attack("Forest", 3, 3)
    soldiersAttack.attack("Forest", 3, 3)

    assertThat(points.size, `is`(1))
  }
}
