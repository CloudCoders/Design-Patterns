package oop.Memento

class CareTaker<T> {
  private val mementoList = mutableListOf<Memento<T>>()

  fun addMemento(memento: Memento<T>) {
    mementoList.add(memento)
  }

  fun getMemento(index: Int) : Memento<T>? = mementoList[index]
}
