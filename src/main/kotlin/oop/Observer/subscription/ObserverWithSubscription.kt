package oop.Observer.subscription

import kotlin.system.measureTimeMillis

class PublishSubject<A>(private val observers: MutableList<Observer<A>> = mutableListOf()) {

  fun register(observer: Observer<A>): Observer<A> {
    observers.add(observer)
    return observer
  }

  fun notify(value: A) {
    observers.forEach { it.update(value) }
  }

}

open class Observer<A>(private val value: A) {

  private var subscription: Subscription<A>? = null

  open fun update(value: A) {
    if (subscription?.isSubscribed ?: false) {
      subscription?.update?.invoke(value)
    }
  }

  fun subscribe(success: (A) -> Unit, update: (A) -> Unit): Subscription<A> {
    success(value)
    return Subscription(update).also { subscription = it }
  }

}


class Subscription<A> internal constructor(internal val update: (A) -> Unit,
                                           internal var isSubscribed: Boolean = true) {

  fun unregister() {
    isSubscribed = false
  }

  fun register() {
    isSubscribed = true
  }
}

fun main(args: Array<String>) {
  val success: (String) -> Unit = { println("Value: $it") }

  val subject: PublishSubject<String> = PublishSubject()

  var firstSub = subject.register(Observer("First request a value and updates"))
    .subscribe(success, { println("First updated: $it") })
  var secondSub = subject.register(Observer("Second request only updates"))
    .subscribe({}, { println("Second updated: $it") })
  var thirdSub = subject.register(Observer("Third request a value"))
    .subscribe(success, {})

  println()
  println("Notify: Toni")
  subject.notify("Toni"); println()
  println("Notify: Cotel")
  subject.notify("Cotel"); println()

  println("Unregister all"); println()
  firstSub.unregister()
  secondSub.unregister()
  thirdSub.unregister()

  println("Notify: Fran")
  subject.notify("Fran")
  println("Nothing happens");println()

  println("Register first and second"); println()
  firstSub.register()
  secondSub.register()

  println("Notify: That's all")
  subject.notify("That's all"); println()
}
