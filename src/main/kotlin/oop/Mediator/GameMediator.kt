package oop.Mediator

class GameMediator : Mediator<Player> {
  override var recipients = mutableListOf<Player>()

  var lastPlayed: Int = 0

  override fun add(recipient: Player) {
    recipients.add(recipient)
  }

  fun setNextTurn(index: Int) {
    var nextToPlay = recipients.get(index)
    nextToPlay.isMyTurn = true
    recipients.set(index, nextToPlay)
  }

  fun `set player turn to false at`(index: Int) {
    lastPlayed = index
    val res = recipients.get(index)
    res.isMyTurn = false
    recipients.set(index, res)
  }

  override fun performPlay(sender: Player) {
    recipients.forEachIndexed { index, player ->
      if (sender.equals(player)) {
        `set player turn to false at`(index)
        player.recieve("Wait, waiting for player ${index + 1}")

      } else {
        if (lastPlayed + 1 == index) {
          setNextTurn(index)
          player.recieve("Is your turn")
        } else {
          player.recieve("Wait, waiting for player ${lastPlayed+1}")
        }
      }
    }
  }

}
