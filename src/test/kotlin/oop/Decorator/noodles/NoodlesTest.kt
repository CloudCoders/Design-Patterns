package oop.Decorator.noodles

import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Test

class NoodlesTest {

  @Test
  fun `check correctness of wheat noodles's cost`() {
    val wheatNoodles = WheatNoodles()
    assertThat(wheatNoodles.calculateCost(), CoreMatchers.`is`(3.50))
  }

  @Test
  fun `check correctness of egg noodles's cost`() {
    val eggNoodles = EggNoodles()
    assertThat(eggNoodles.calculateCost(), CoreMatchers.`is`(3.75))
  }

  @Test
  fun `check correctness of udon noodles's cost`() {
    val udonNoodles = UdonNoodles()
    assertThat(udonNoodles.calculateCost(), CoreMatchers.`is`(4.00))
  }

}
