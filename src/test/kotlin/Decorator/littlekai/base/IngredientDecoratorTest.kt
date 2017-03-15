package Decorator.littlekai.base

import Decorator.littlekai.ingredients.Chicken
import Decorator.littlekai.ingredients.Peanuts
import Decorator.littlekai.ingredients.Pork
import Decorator.littlekai.ingredients.Tuna
import Decorator.littlekai.noodles.EggNoodles
import Decorator.littlekai.noodles.UdonNoodles
import Decorator.littlekai.noodles.WheatNoodles
import Decorator.littlekai.sauces.BittersweetSauce
import Decorator.littlekai.sauces.RedPepperSauce
import Decorator.littlekai.sauces.SateSauce
import Decorator.littlekai.sauces.TeriyakiSauce
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

  @Test
  fun `has the same interface`() =
    assertTrue(BittersweetSauce(Chicken(EggNoodles())) is Noodles)

  @Test
  fun `does not modify behavior`() =
    assertTrue(EggNoodles().calculateCost() == BittersweetSauce(Chicken(EggNoodles())).calculateCost())

  @Test
  fun `adds behavior`() {


  }

  @Test
  fun `is stackable`() {

  }
}
