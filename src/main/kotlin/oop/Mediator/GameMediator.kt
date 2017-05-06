package oop.Mediator

class GameMediator : Mediator<Player> {
  override val recipients = mutableListOf<Player>()

  var lastTurn = 0

  override fun add(recipient: Player) {
    recipients.add(recipient)
  }

  override fun performPlay(sender: Player) {
    recipients.forEachIndexed { index, player ->
      if (sender == player) {
        player.isMyTurn = false
        lastTurn = index
      }
      if (recipients[lastTurn+1] == player) {
        player.apply { isMyTurn = true; receive("Is your turn") }
      } else {
        player.receive("Waiting for player ${lastTurn+1}")
      }
    }
  }

}
