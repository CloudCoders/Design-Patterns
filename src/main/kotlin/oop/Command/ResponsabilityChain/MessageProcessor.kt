package oop.Command.ResponsabilityChain

interface MessageProcessor {

  fun process(message: Message) : String

}
