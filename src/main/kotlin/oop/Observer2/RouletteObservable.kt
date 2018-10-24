package oop.Observer2

import kotlin.properties.Delegates

class RouletteObservable {

  private val observers = mutableListOf<Observer<String>>()

  var newCategory: String by Delegates.observable("") { _, _, new ->
    observers.forEach { it.onChange(new) }
  }

  fun addObserver(observer: Observer<String>) {
    observers.add(observer)
  }

  fun removeObserver(observer: Observer<String>) {
    observers.remove(observer)
  }
}
