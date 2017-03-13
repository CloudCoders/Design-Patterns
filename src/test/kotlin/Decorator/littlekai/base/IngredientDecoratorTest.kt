package Decorator.littlekai.base

import Decorator.littlekai.ingredients.Pork
import Decorator.littlekai.ingredients.Tuna
import Decorator.littlekai.noodles.EggNoodles
import Decorator.littlekai.noodles.UdonNoodles
import Decorator.littlekai.noodles.WheatNoodles
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test

class IngredientDecoratorTest {

  val baseNoodles = UdonNoodles()
  val ingredient = Pork(baseNoodles)
  val doubleIngredient = Tuna(ingredient)

  @Test
  fun `check if decorated element is still Noodles`() =
    assertTrue(ingredient is Noodles)


  @Test
  fun `check type of stacked decorators should be equal to last`() =
    assertTrue(doubleIngredient is Tuna)

  @Test
  fun `check decorated Noodles is of type IngredientDecorator`() =
    assertTrue(doubleIngredient is IngredientDecorator)

  @Test
  fun `check price of Ingredient is calculated correctly`() =
    assertThat(doubleIngredient.calculateCost(), `is`(baseNoodles.COST + ingredient.COST + doubleIngredient.COST))

  @Test
  fun `check correctness of wheat noodles's cost`(){
    val wheatNoodles = WheatNoodles()
    assertThat(wheatNoodles.calculateCost(), `is`(3.50))
  }

  @Test
  fun `check correctness of egg noodles's cost`(){
    val eggNoodles = EggNoodles()
    assertThat(eggNoodles.calculateCost(), `is`(3.75))
  }

  @Test
  fun `check correctness of udon noodles's cost`(){
    val udonNoodles = UdonNoodles()
    assertThat(udonNoodles.calculateCost(), `is`(4.00))
  }

}
