package oop.Proxy

/**
 * Remote Proxy[edit]
In distributed object communication, a local object represents a remote object (one that belongs to a different address space).
The local object is a proxy for the remote object, and method invocation on the local object results in remote method invocation on the remote object.
An example would be an ATM implementation, where the ATM might hold proxy objects for bank information that exists in the remote server.
 *
 * See https://en.wikipedia.org/wiki/Distributed_object_communication
 */

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

class MessageServerObject(private val serverDomain: ServerDomain = ServerDomain()) : Message {

  override fun writeInChannel(message: String, channel: String) {
    serverDomain.channels.forEach {
      if (it == channel){
        println("Message in $channel: $message")
      }
    }
  }

}

class ServerDomain(val channels: MutableList<String> = mutableListOf())

class SimulateOutputStream(private val networkSimulationMessageServerObject: Message) {

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
