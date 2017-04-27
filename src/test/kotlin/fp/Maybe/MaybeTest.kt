package fp.Maybe

import fp.Maybe.Maybe.Just
import fp.Maybe.Maybe.None
import junit.framework.Assert.assertEquals
import org.junit.Test


class MaybeTest {

  @Test
  fun `map should modify value`() {
    assertEquals(Just(33).map { 1 }, Just(1))
    assertEquals(None.map{ 1 }, None)
  }

  @Test
  fun `flatMap should modify entity`() {
    assertEquals(Just(33).flatMap { Just("Hello") }, Just("Hello"))
    assertEquals(Just(33).flatMap { None }, None)
    assertEquals(None.flatMap { Just(1) }, None)
  }

  @Test
  fun `getOrElse should return value`() {
    assertEquals(Just(33).getOrElse { 0 }, 33)
    assertEquals(None.getOrElse { 0 }, 0)
  }

  @Test
  fun `fold should call default on None`() {
    assertEquals(None.fold({ "This is default" }, { Exception() }), "This is default")
  }

  @Test
  fun `fold should call function on Just`() {
    assertEquals(Just(33).fold({ Exception() }, { it*2 }), 66)
  }


  @Test
  fun `if flatMap result is null should return None`() {
    val just33 = Just(33)
    val nullIfLowerThan100 = { it: Int -> if (it < 100) null else it }
    assertEquals(just33.flatMap { Maybe.fromNullable(nullIfLowerThan100(it)) }, None)
  }
}
