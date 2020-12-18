package oop.Mediator

interface Mediator<T> {
  val recipients: MutableList<T>
  fun add(recipient: T)
  fun performPlay(sender: T)
}
