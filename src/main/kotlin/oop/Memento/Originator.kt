package oop.Memento

class Originator<T>(var state : T) {
  fun saveToMemento() = Memento(state)
  fun loadFromMemento(memento: Memento<T>) {
    state = memento.state
  }
}
