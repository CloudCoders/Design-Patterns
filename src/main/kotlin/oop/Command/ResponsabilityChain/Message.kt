package oop.Command.ResponsabilityChain

sealed class Message(val message : String) {

  class Username(userMessage: String) : Message(userMessage)

  class Password(passMessage : String) : Message(passMessage)

  class PlainText(textMessage: String) : Message(textMessage)

}
