package oop.Command.commands

import oop.Command.base.Cart
import org.junit.Assert.*
import org.junit.Test
import java.util.*


class ChooseIngredientCommandTest {

  @Test
  fun `should matches when command is 2`() {
    val fake = Scanner("") //First concept of test doubles - fake -
    val dummy = Cart(fake) //Second concept of test doubles - dummy -
    assertTrue(ChooseIngredientCommand(dummy).matches("2"))
  }

  @Test
  fun `should not matches when command is any other than 2`(){
    val dummy = Cart(Scanner(""))
    assertFalse(ChooseIngredientCommand(dummy).matches("3 or something"))
  }

  @Test
  fun `should execute a choose ingredient from cart`() {
    val mock = MockCart() //Third concept of test doubles - mock -
    val chooseIngredientCommand = ChooseIngredientCommand(mock)

    chooseIngredientCommand.execute()

    assertTrue(mock.chooseIngredientCalls) //the command calls chooseIngredient method when execute?
  }


  //Custom Mock object
  inner class MockCart(var chooseIngredientCalls: Boolean = false)
    : Cart(Scanner("")) {

    /**
     * Removed original behaviour because I don't care
     */
    override fun chooseIngredient() {
      chooseIngredientCalls = true
    }

  }

}
