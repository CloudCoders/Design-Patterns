package oop.Command.ResponsabilityChain

class UsernameProcessor(val next: MessageProcessor = PasswordProcessor()) : MessageProcessor {

  override fun process(message: Message) : String {
    if (message is Message.Username) {
      return message.message.toUpperCase()
    } else {
      return next.process(message)
    }
  }

}
