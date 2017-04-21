package oop.ResponsabilityChain

object ProcessingComposite : MessageProcessor {

  val bottom = PlainTextProcessor()
  val next = PasswordProcessor(bottom)
  val usernameProcessor = UsernameProcessor(next)

  override fun process(message: Message): String = usernameProcessor.process(message)
}
