package oop.Mediator

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import oop.Iterator.BackwardsIterator
import oop.Iterator.Iterator
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test

/**
 * Created by ConradoMateu on 04/05/17.
 */
class GameMediatorTest {
  private val mediator: Mediator<Player> = GameMediator()

  var players = playerGenerator(4)


  @Before
  fun init() {
    players.forEach { mediator.add(it) }
  }

  fun playerGenerator(index: Int): MutableList<Player> {
    var recipients = mutableListOf<Player>()
    var player: Player?
    for (i in 1..index) {
      if (i == 1) player = Player("Player $i", true) else player = Player("Player $i", false)
      recipients.add(player)
    }
    return recipients
  }


  @Test
  fun `Return last item of collection when call`() {

  }

  @Test
  fun `when a player has played should't be his turn`() {
    val firtPlayer = players.first()
    firtPlayer.play(mediator)
    assertFalse(firtPlayer.isMyTurn)
  }

  @Test
  fun `if player has played should give turn to next player`() {
    val firtPlayer = players.first()
    val secondPlayer = players[1]
    firtPlayer.play(mediator)
    assertFalse(firtPlayer.isMyTurn)
    assertTrue(secondPlayer.isMyTurn)
  }


}
