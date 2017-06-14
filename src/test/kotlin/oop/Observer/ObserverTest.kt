package oop.Observer

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.assertion.assert
import org.junit.Test
import kotlin.properties.Delegates


class ObserverTest {

  var observer = object : Observer<Int> {
    override fun onValueChange(newValue: Int, oldValue: Int) {
      timesChanged++
    }
  }

  var counter by Delegates.observable(0) { _, old, new ->
    observer.onValueChange(new, old)
  }

  var timesChanged = 0

  val `is` = { number: Int -> Matcher(Int::equals, number) }

  @Test
  internal fun `observer should increment timesChanged on change`() {
    assert.that(timesChanged, `is`(0))

    counter++
    assert.that(timesChanged, `is`(1))

    counter--
    assert.that(timesChanged, `is`(2))
  }
}
