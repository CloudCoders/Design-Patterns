package Composite

import Composite.base.ChineseCooker
import Composite.base.Cooker
import Composite.base.ItalianCooker
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CompositeTest {

  @Test
  fun `composite should allow to add more childrens`() {
    val kitchen = MockKitchen()
    assertThat(kitchen.cookers.size, `is`(0))

    val italian = ItalianCooker()
    kitchen.add(italian)
    assertThat(kitchen.cookers.size, `is`(1))
  }

  @Test
  fun `composite should allow to remove childrens`() {
    val kitchen = MockKitchen()
    val italian = ItalianCooker()
    kitchen.add(italian)
    assertThat(kitchen.cookers.size, `is`(1))

    kitchen.remove(italian)
    assertThat(kitchen.cookers.size, `is`(0))
  }

  @Test
  fun `times cooked should be equal to cookers length after cooking with all childrens of composite`() {
    val kitchen = MockKitchen()
    val italian = ItalianCooker()
    val chinese = ChineseCooker()
    kitchen.add(italian)
    kitchen.add(chinese)

    kitchen.cook()
    assertThat(kitchen.timesCooked, `is`(kitchen.cookers.size))
  }

}

class MockKitchen(var cookers: MutableList<Cooker> = mutableListOf()) : Cooker {
  var timesCooked : Int = 0

  override fun cook() {
    timesCooked = cookers.map(Cooker::cook).size
  }

  fun add(cooker: Cooker) = cookers.add(cooker)

  fun remove(cooker: Cooker) {
    cookers = cookers.filterNot { it == cooker } as MutableList<Cooker>
  }
}
