package oop.Decorator.base

import oop.Decorator.ingredients.Pork
import oop.Decorator.ingredients.Tuna
import oop.Decorator.noodles.EggNoodles
import oop.Decorator.noodles.UdonNoodles
import oop.Decorator.noodles.WheatNoodles
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test

class IngredientDecoratorTest {

  @Test
  fun `check if decorated element is still Noodles`() =
    assertTrue(Pork(UdonNoodles()) is Noodles) //:+1:

  @Test
  fun `Ingredient Decorator should return ingredient cost plus base noodle cost`() =
    assertThat(Pork(UdonNoodles()).calculateCost(), `is`(8.00))


  @Test
  fun `check decorated Noodles is of type IngredientDecorator`() =
    assertTrue(Tuna(UdonNoodles()) is IngredientDecorator)

  @Test
  fun `price of ingredient is calculated correctly`() =
    assertThat(Tuna(Pork(UdonNoodles())).calculateCost(), `is`(10.75))

}
