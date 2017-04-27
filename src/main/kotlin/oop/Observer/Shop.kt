package oop.Observer

import kotlin.properties.Delegates

class Shop(private val customersObserver : CustomersObserver) {

  private var currentCustomers by Delegates.observable(0) { _, old, new ->
    customersObserver.onValueChange(new, old)
  }

  fun customerEnter() = currentCustomers++

  fun customerLeave() = currentCustomers--

}
