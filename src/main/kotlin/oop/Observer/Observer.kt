package oop.Observer


interface Observer<in T> {
  fun onValueChange(newValue: T, oldValue: T)
}
