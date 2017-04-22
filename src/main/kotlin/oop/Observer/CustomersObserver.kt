package oop.Observer


class CustomersObserver : Observer<Int> {

  override fun onValueChange(newValue: Int, oldValue: Int) = when {
    newValue > oldValue -> println("A new customer entered. Current customers: $newValue")
    else -> println("A customer left. Current customers: $newValue")
  }

}
