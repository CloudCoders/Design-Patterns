package oop.ResponsabilityChain

class PlainTextProcessor(val next : MessageProcessor? = null) : MessageProcessor {

  override fun process(message: Message): String {
    if (message is Message.PlainText) {
      return message.message
    } else {
      return next?.process(message) ?: message.message
    }
  }

}
