package oop.Command.ResponsabilityChain

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ProcessingChainTest {

  @Test
  fun `username message should be transformed into upper case`() {
    val usernameMessage = Message.Username("Pepito")
    val transformation = ProcessingComposite.process(usernameMessage)

    assertThat(transformation, `is`("PEPITO"))
  }

  @Test
  fun `password message should be transformed into * string`() {
    val password = Message.Password("secreto")
    val transformation = ProcessingComposite.process(password)

    assertThat(transformation, `is`("*******"))
  }

  @Test
  fun `plain text message should remain the same`() {
    val plainText = Message.PlainText("El buen texto")
    val transformation = ProcessingComposite.process(plainText)

    assertThat(transformation, `is`("El buen texto"))
  }



}
