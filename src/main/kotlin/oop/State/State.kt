package oop.State

interface State {
  fun next(): State
}

sealed class SemaphoreStates : State {
  object Red : SemaphoreStates() {
    override fun next() = Green
  }

  object Green : SemaphoreStates() {
    override fun next() = Yellow
  }

  object Yellow : SemaphoreStates() {
    override fun next() = Red
  }
}

class Semaphore(startingState: State = SemaphoreStates.Red) {
  var state = startingState
    private set

  fun nextLight() {
    state = state.next()
  }
}
