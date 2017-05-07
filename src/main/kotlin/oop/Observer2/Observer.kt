package oop.Observer2

interface Observer<T> {
  fun onChange(newValue: T)
}
