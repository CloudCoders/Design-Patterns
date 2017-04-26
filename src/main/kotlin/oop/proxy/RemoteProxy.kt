package oop.proxy

interface Message {
  fun writeInChannel(message: String, channel: String)
}

class MessageRemoteProxy(private val ouputStream: SimulateOutputStream) : Message {

  private val addHeadTCP = ":TCPInformationLOL:"
  private val tailTCP = ":TCPendlol:"

  override fun writeInChannel(message: String, channel: String) {
    ouputStream.write(addHeadTCP + message + ":" + channel + tailTCP)
    ouputStream.close()
  }
}

open class MessageServerObject(private val serverDomain: ServerDomain = ServerDomain()) : Message {

  override fun writeInChannel(message: String, channel: String) {
    serverDomain.channels.forEach {
      if (it == channel){
        println("Message in $channel: $message")
      }
    }
  }

}

class ServerDomain(val channels: MutableList<String> = mutableListOf())

class SimulateOutputStream(private val networkSimulationMessageServerObject: MessageServerObject) {

  fun write(string: String) {
    println("write message on network: $string")

    //when you sends the information another remote API,
    // grab this information and transform to remote object in his machine

    //IN MY SERVER

    var (message, channel) = string
      .removePrefix(":TCPInformationLOL:")
      .removeSuffix(":TCPendlol:")
      .split(":")

    networkSimulationMessageServerObject.writeInChannel(message, channel)

    //MY SERVER LEFT
  }

  fun close() {}
}
