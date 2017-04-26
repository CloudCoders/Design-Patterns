package oop.Proxy

import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Test

class ScreenVirtualProxyTest {

  @Test
  fun `not create real object in proxy construction`() {
    var screenVirtualProxy = ScreenVirtualProxy({ RealScreen() })

    assertNull(screenVirtualProxy.realScreen)
  }

  @Test
  fun `create real object when show screen`() {
    var screenVirtualProxy = ScreenVirtualProxy({ RealScreen() })

    screenVirtualProxy.show()

    assertNotNull(screenVirtualProxy.realScreen)
  }

  @Test
  fun `create real object once when show screen`() {
    var createCount = 0

    var screenVirtualProxy = ScreenVirtualProxy({
      createCount++
      RealScreen()
    })

    screenVirtualProxy.show()
    screenVirtualProxy.show()


    assertThat(createCount, `is`(1))
  }

}
