package oop.Mediator

class Player(val name: String, var isMyTurn: Boolean = false) {
  fun recieve(message: String) {
    println("$name recieved: $message")

  }

  fun play(mediator: Mediator<Player>) {
    mediator.performPlay(this)
  }
}
