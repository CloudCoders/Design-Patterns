package oop.Composite

import oop.Composite.base.Cooker
import oop.Composite.base.ItalianCooker
import oop.Composite.base.Kitchen
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CompositeTest {

  /**
   * Example of "spies" without using your MockKitchen because don't need that
   */
  @Test
  fun `composite should allow to add more childrens`() {
    val cookers = mutableListOf<Cooker>()
    val kitchen = Kitchen(cookers)
    assertThat(cookers.size, `is`(0))

    val italian = ItalianCooker()
    kitchen.add(italian)
    assertThat(cookers.size, `is`(1))
  }

  @Test
  fun `composite should allow to remove childrens`() {
    val cookers = mutableListOf<Cooker>()
    val kitchen = Kitchen(cookers)
    val italian = ItalianCooker()
    kitchen.add(italian)
    assertThat(cookers.size, `is`(1))

    kitchen.remove(italian)
    assertThat(cookers.size, `is`(0))
  }

  /**
   * HERE YOU WANT TO KNOW IF ALL COOKERS ARE CALLED :+1:
   */
  @Test
  fun `times cooked should be equal to cookers length after cooking with all childrens of composite`() {
    val cookers = mutableListOf<Cooker>()
    val kitchen = Kitchen(cookers)
    val italian = MockCooker()
    val chinese = MockCooker()
    kitchen.add(italian)
    kitchen.add(chinese)

    kitchen.cook()
    assertThat(italian.times + italian.times, `is`(cookers.size))
  }

}

class MockCooker : Cooker {

  var times = 0

  override fun cook() {
    times++
  }

}
