package oop.Observer2

interface Observer<T>{
  val list: MutableList<Player>
  fun onChange(newValue: T)
}
