package oop.Mediator

/**
 * Created by ConradoMateu on 03/05/17.
 */
interface Mediator<T> {
  var recipients: MutableList<T>
  fun add(recipient: T)
  fun performPlay(sender: T)
}
