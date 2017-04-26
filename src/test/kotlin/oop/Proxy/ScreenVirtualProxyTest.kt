package oop.Proxy

import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Test

class ScreenVirtualProxyTest {

  @Test
  fun `not create real object in proxy construction`() {
    var createCount = 0
    var createRealScreen = {
      createCount++
      RealScreen()
    }

    val screenVirtualProxy = ScreenVirtualProxy(createRealScreen)

    assertThat(createCount, `is`(0))
  }

  @Test
  fun `create real object when show screen`() {
    val screenVirtualProxy = ScreenVirtualProxy({ RealScreen() })

    screenVirtualProxy.show()

    assertNotNull(screenVirtualProxy.realScreen)
  }

  @Test
  fun `create real object once when show screen`() {
    var createCount = 0

    val screenVirtualProxy = ScreenVirtualProxy({
      createCount++
      RealScreen()
    })

    screenVirtualProxy.show()
    screenVirtualProxy.show()


    assertThat(createCount, `is`(1))
  }

}
