package oop.Observer2

import kotlin.properties.Delegates

class Roulette{

  var observer: CategoryObserver? = null

  var newCategory: String by Delegates.observable("") { _, _, new ->
    observer?.onChange(new)
  }
}
