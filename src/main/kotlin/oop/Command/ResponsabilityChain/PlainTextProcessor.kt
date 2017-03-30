package oop.Command.ResponsabilityChain

class PlainTextProcessor() : MessageProcessor {

  override fun process(message: Message): String = message.message

}
