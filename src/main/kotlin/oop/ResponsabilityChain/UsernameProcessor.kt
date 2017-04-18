package oop.ResponsabilityChain

class UsernameProcessor(val next: MessageProcessor? = null) : MessageProcessor {

  override fun process(message: Message) : String {
    if (message is Message.Username) {
      return message.message.toUpperCase()
    } else {
      return next?.process(message) ?: message.message
    }
  }

}
