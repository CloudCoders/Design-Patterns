package oop.Flyweigth

import oop.Flyweight.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class FlyweightPatternShould {

  @Before
  fun initTests(){
    Flyweight.objectInstances = 0
    SoldierFactory.clearInstances()
  }

  @Test
  fun `Have one instance when only one type of soldier is created`() {
    SoldierClient(Admiral.TYPE)
    SoldierClient(Admiral.TYPE)
    SoldierClient(Admiral.TYPE)

    assertThat(Flyweight.objectInstances, `is`(1))
  }
  @Test
  fun `Have two instances when both types are created, no matter the number of soldiers`(){
    (1..Random().nextInt(30)).forEach {
      SoldierClient(Admiral.TYPE)
      SoldierClient(Captain.TYPE)
    }

    assertThat(Flyweight.objectInstances, `is`(2))
  }

  @Test
  fun `Have the same main object in two instances of the same type`(){
    val soldierOne: SoldierClient = SoldierClient(Admiral.TYPE)
    val soldierTwo: SoldierClient = SoldierClient(Admiral.TYPE)

    assertThat(soldierOne.getSoldier(), `is`(soldierTwo.getSoldier()))
  }
}
