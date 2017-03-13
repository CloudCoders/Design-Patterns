package Command.base

import Command.commands.*
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.*


class ProcessorTest {

  val cart = Cart(Scanner(System.`in`))
  val commands = listOf(
    ChooseIngredientCommand(cart),
    ChooseNoodlesCommand(cart),
    ChooseSauceCommand(cart),
    ShowPriceCommand(cart)
  )
  val processor = Processor(commands, CommandNotFound())

  @Test
  fun `check if command matcher matches correctly`() {
    assertThat(processor.process("2") is ChooseIngredientCommand, `is`(true))
  }

  @Test
  fun `check if command does not match it returns CommandNotFound`() {
    assertThat(processor.process("Bad matching") is CommandNotFound, `is`(true))
  }

}
