package oop.Command.ResponsabilityChain

object ProcessingComposite : MessageProcessor {

  val usernameProcessor = UsernameProcessor()

  override fun process(message: Message): String = usernameProcessor.process(message)
}
