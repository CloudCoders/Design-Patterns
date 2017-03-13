package Decorator.littlekai.base

import Decorator.littlekai.ingredients.Pork
import Decorator.littlekai.ingredients.Tuna
import Decorator.littlekai.noodles.UdonNoodles
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class IngredientDecoratorTest {

  val baseNoodles = UdonNoodles()
  val ingredient = Pork(baseNoodles)
  val doubleIngredient = Tuna(ingredient)

  @Test
  fun `check if decorated element is still Noodles`() =
    assertThat(ingredient is Noodles, `is`(true))

  @Test
  fun `check type of stacked decorators should be equal to last`() =
    assertThat(doubleIngredient is Tuna, `is`(true))

  @Test
  fun `check decorated Noodles is of type IngredientDecorator`() =
    assertThat(doubleIngredient is IngredientDecorator, `is`(true))

  @Test
  fun `check price of Ingredient is calculated correctly`() =
    assertThat(doubleIngredient.calculateCost(), `is`(baseNoodles.COST + ingredient.COST + doubleIngredient.COST))

}
