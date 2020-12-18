package oop.Mediator

data class Player(val name: String,
                  var isMyTurn: Boolean = false) {
  fun receive(message: String) {
    println("$name recieved: $message")
  }

  fun play(mediator: Mediator<Player>) {
    mediator.performPlay(this)
  }
}
