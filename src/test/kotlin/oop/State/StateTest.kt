package oop.State

import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.*
import org.junit.Test

class StateTest {

  @Test
  fun `semaphore should start in red colour`() {
    val semaphore = Semaphore()

    assertThat(semaphore.state, instanceOf(SemaphoreStates.Red::class.java))
  }

  @Test
  fun `semaphore should change state red to green`(){
    val semaphore = Semaphore()

    semaphore.changeState()

    assertThat(semaphore.state, instanceOf(SemaphoreStates.Green::class.java))
  }

  @Test
  fun `semaphore should change state green to ambar`(){
    val semaphore = Semaphore()

    semaphore.changeState() //red to green
    semaphore.changeState() //green to ambar

    assertThat(semaphore.state, instanceOf(SemaphoreStates.Ambar::class.java))
  }

  @Test
  fun `semaphore should change state ambar to red`(){
    val  semaphore = Semaphore()

    semaphore.changeState()
    semaphore.changeState()
    semaphore.changeState() //ambar to red

    assertThat(semaphore.state, instanceOf(SemaphoreStates.Red::class.java))
  }

}
