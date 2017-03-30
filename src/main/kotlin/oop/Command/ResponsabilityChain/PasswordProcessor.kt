package oop.Command.ResponsabilityChain

class PasswordProcessor(val next : MessageProcessor = PlainTextProcessor()) : MessageProcessor {

  override fun process(message: Message) : String {
   if (message is Message.Password) {
     return message.message.map { '*' }.joinToString(separator = "")
   } else {
     return next.process(message)
   }
  }

}

