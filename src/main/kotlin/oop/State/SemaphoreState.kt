package oop.State

sealed class SemaphoreState {

  class GreenSemaphore : SemaphoreState()

  class RedSemaphore : SemaphoreState()

  class YellowSemaphore : SemaphoreState()

}

