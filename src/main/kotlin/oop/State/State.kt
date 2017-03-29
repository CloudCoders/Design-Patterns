package oop.State

interface State {

  fun next(): State
}

sealed class SemaphoreStates() : State {

  class Red : SemaphoreStates() {
    override fun next(): State {
      println("Red")
      return Green()
    }
  }

  class Green : SemaphoreStates() {
    override fun next(): State {
      println("Green")
      return Ambar()
    }
  }

  class Ambar : SemaphoreStates() {
    override fun next(): State {
      println("Ambar")
      return Red()
    }
  }
}

class Semaphore(var state: State = SemaphoreStates.Red()) {

  fun changeState() {
    state = state.next()
  }

}
