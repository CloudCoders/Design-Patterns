package oop.proxy

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

/**
 * Test of my implementation example, nothing related for object proxy
 */
class MessageRemoteProxyTest {

  @Test
  fun `write correct message and channel in server`() {
    val networkSimulationMessageServerObject = MessageServerObjectMock()
    val outputStream = SimulateOutputStream(networkSimulationMessageServerObject)
    val messageRemoteProxy = MessageRemoteProxy(outputStream)

    messageRemoteProxy.writeInChannel("Hello World!", "myChannel")

    assertThat(networkSimulationMessageServerObject.message, `is`("Hello World!"))
    assertThat(networkSimulationMessageServerObject.channel, `is`("myChannel"))
  }

  class MessageServerObjectMock(var message: String = "",
                                var channel: String = "") : MessageServerObject() {

    override fun writeInChannel(message: String, channel: String) {
      this.message = message
      this.channel = channel
    }
  }

}
