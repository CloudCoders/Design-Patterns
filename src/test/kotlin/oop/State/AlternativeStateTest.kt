package oop.State

import oop.State.SemaphoreState.*
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class AlternativeStateTest {

  @Test
  fun `starting light of semaphore should be Red`() {
    val semaphore = SemaphorePresenter()
    assertThat(semaphore.currentLight, instanceOf(RedSemaphore::class.java))
  }

  @Test
  fun `semaphore should change from Red to Green`() {
    val semaphore = SemaphorePresenter()
    semaphore.nextLight()
    assertThat(semaphore.currentLight, instanceOf(GreenSemaphore::class.java))
  }

  @Test
  fun `semaphore should change from Green to Yellow`() {
    val semaphore = SemaphorePresenter(currentLight = GreenSemaphore())
    semaphore.nextLight()
    assertThat(semaphore.currentLight, instanceOf(YellowSemaphore::class.java))
  }

  @Test
  fun `semaphore should change from Yellow to Red`() {
    val semaphore = SemaphorePresenter(currentLight = YellowSemaphore())
    semaphore.nextLight()
    assertThat(semaphore.currentLight, instanceOf(RedSemaphore::class.java))
  }

}


open class SemaphorePresenter(var currentLight: SemaphoreState = RedSemaphore()) {

  fun nextLight() {
    when (currentLight) {
      is SemaphoreState.RedSemaphore -> currentLight = GreenSemaphore()
      is SemaphoreState.GreenSemaphore -> currentLight = YellowSemaphore()
      is SemaphoreState.YellowSemaphore -> currentLight = RedSemaphore()
    }
  }

}
