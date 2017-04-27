package oop.Iterator


import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class BackwardsIteratorShould {
  private val list = mutableListOf("10", "12", "15", "29", "30", "36")
  private val iterator: Iterator<String> = BackwardsIterator(list)

  @Test
  fun `Return last item of collection when call`(){
    assertThat(iterator.first(),`is`("36"))
  }

  @Test
  fun `Iterate list from back to start`(){
    var res = ""
    iterator.first()
    iterator.forEach {
      res += "$it,"
    }
    assertThat(res, `is`("36,30,29,15,12,10,"))
  }
}
