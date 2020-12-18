package oop.Mediator

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameMediatorTest {
  private val mediator: Mediator<Player> = GameMediator()

  val players = generatePlayers(4)


  @Before
  fun init() {
    players.forEach { mediator.add(it) }
  }

  fun generatePlayers(number: Int): MutableList<Player> {
    val players = mutableListOf<Player>()
    (1..number).forEach { players.add(if (it == 1) Player("Player $it", true) else Player("Player $it")) }
    return players
  }


  @Test
  fun `Return last item of collection when call`() {

  }

  @Test
  fun `when a player has played should't be his turn`() {
    val firstPlayer = players.first()
    firstPlayer.play(mediator)
    assertFalse(firstPlayer.isMyTurn)
  }

  @Test
  fun `if player has played should give turn to next player`() {
    val firstPlayer = players.first()
    val secondPlayer = players[1]
    firstPlayer.play(mediator)
    assertFalse(firstPlayer.isMyTurn)
    assertTrue(secondPlayer.isMyTurn)
  }


}
