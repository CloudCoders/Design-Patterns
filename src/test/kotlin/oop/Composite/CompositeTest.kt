package oop.Composite

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CompositeTest {

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

  @Test
  fun `times cooked should be equal to cookers length after cooking with all childrens of composite`() {
    val cookers = mutableListOf<Cooker>()
    val kitchen = Kitchen(cookers)
    val italian = MockCooker()
    val another = MockCooker()
    val chinese = MockCooker()
    kitchen.add(italian)
    kitchen.add(another)
    kitchen.add(chinese)

    kitchen.cook()
    assertThat(italian.times + chinese.times + another.times, `is`(cookers.size))
  }

  @Test
  fun `times cooked should be equals to cookers length * 2`(){
    val cookers = mutableListOf<Cooker>()
    val kitchen = Kitchen(cookers)
    val supportCooker = MockCooker()
    val chinese = ChineseCooker(mutableListOf(supportCooker, supportCooker))
    val italian = ItalianCooker(mutableListOf(supportCooker))
    kitchen.add(italian)
    kitchen.add(chinese)

    kitchen.cook()
    assertThat(supportCooker.times, `is`(3))
  }

}

class MockCooker : Cooker {

  var times = 0

  override fun cook() {
    times++
  }

}
