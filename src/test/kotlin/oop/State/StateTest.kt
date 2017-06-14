package oop.State

import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
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

    semaphore.nextLight()

    assertThat(semaphore.state, instanceOf(SemaphoreStates.Green::class.java))
  }

  @Test
  fun `semaphore should change state green to yellow`(){
    val semaphore = Semaphore()

    semaphore.nextLight() //red to green
    semaphore.nextLight() //green to yellow

    assertThat(semaphore.state, instanceOf(SemaphoreStates.Yellow::class.java))
  }

  @Test
  fun `semaphore should change state yellow to red`(){
    val  semaphore = Semaphore(SemaphoreStates.Yellow)

    semaphore.nextLight() //yellow to red

    assertThat(semaphore.state, instanceOf(SemaphoreStates.Red::class.java))
  }

}
