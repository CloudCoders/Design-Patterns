package oop.Iterator

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class IteratorShould {
  private val list = mutableListOf("10", "12", "15", "29", "30", "36")
  private val iterator: Iterator<String> = NormalIterator(list)

  @Test
  fun `Return first element with first`() {
    assertThat(iterator.first(), `is`("10"))
  }

  @Test
  fun `Return fourth element doing first-next-next-next`() {
    iterator.first()
    iterator.next()
    iterator.next()
    iterator.next()
    assertThat(iterator.get(), `is`("30"))
  }

  @Test(expected = NoSuchElementException::class)
  fun `Throw NoSuchElementException if element don't have next `() {
    iterator.first()
    (1..7).forEach { iterator.next() }
  }

  @Test
  fun `Return -1 when ask to prev index in first element`() {
    iterator.first()
    assertThat(iterator.prevIndex(), `is`(-1))
  }


  @Test
  fun `Transform all elements of a list when using map`() {
    val transformList = iterator.map { it.toInt() }
    assertThat(transformList, `is`(listOf(10, 12, 15, 29, 30, 36)))
  }

  @Test
  fun `Filter list with criterion using filter`() {
    val filterList = iterator.filter { it.contains("1") }
    assertThat(filterList, `is`(listOf("10", "12", "15")))
  }

  @Test
  fun `Apply function to all elements`() {
    var res = 0
    iterator.forEach { res += it.toInt() }
    assertThat(res, `is`(132))
  }
}
