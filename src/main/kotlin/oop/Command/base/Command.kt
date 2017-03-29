package oop.Command.base

interface Command {
  fun matches(command : String) : Boolean
  fun execute()
}
