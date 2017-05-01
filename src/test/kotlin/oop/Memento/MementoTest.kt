package oop.Memento

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.assertion.assert
import org.junit.Test

class MementoTest {

  fun <T> `is`(list: List<T>): Matcher<List<T>> = Matcher(List<T>::equals, list)
  fun <T> `is`(list: Memento<T>): Matcher<Memento<T>> = Matcher(Memento<T>::equals, list)

  @Test
  fun `memento state should be equal to last originator state`() {
    val originator = Originator(emptyList<Int>())
    originator.state = listOf(1,2,3)

    val memento = originator.saveToMemento()

    assert.that(originator.state, `is`(memento.state))
  }

  @Test
  fun `originator state should be equal to last memento loaded`() {
    val memento = Memento(listOf(1,2,3))
    val originator = Originator(emptyList<Int>())

    originator.loadFromMemento(memento)

    assert.that(originator.state, `is`(memento.state))
  }

  @Test
  fun `care taker should store mementos`() {
    val careTaker = CareTaker<List<Int>>()
    val originator = Originator(listOf(1,2,3))
    val memento = originator.saveToMemento()

    careTaker.addMemento(memento)

    assert.that(careTaker.getMemento(0)!!, `is`(memento))
  }

}
