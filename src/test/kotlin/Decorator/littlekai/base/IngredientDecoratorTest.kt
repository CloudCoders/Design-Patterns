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
  fun `has the same interface`() {
    assertTrue(BittersweetSauce(Chicken(EggNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Chicken(UdonNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Chicken(WheatNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Peanuts(EggNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Peanuts(UdonNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Peanuts(WheatNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Pork(EggNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Pork(UdonNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Pork(WheatNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Tuna(EggNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Tuna(UdonNoodles())) is Noodles)
    assertTrue(BittersweetSauce(Tuna(WheatNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Chicken(EggNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Chicken(UdonNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Chicken(WheatNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Peanuts(EggNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Peanuts(UdonNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Peanuts(WheatNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Pork(EggNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Pork(UdonNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Pork(WheatNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Tuna(EggNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Tuna(UdonNoodles())) is Noodles)
    assertTrue(RedPepperSauce(Tuna(WheatNoodles())) is Noodles)
    assertTrue(SateSauce(Chicken(EggNoodles())) is Noodles)
    assertTrue(SateSauce(Chicken(UdonNoodles())) is Noodles)
    assertTrue(SateSauce(Chicken(WheatNoodles())) is Noodles)
    assertTrue(SateSauce(Peanuts(EggNoodles())) is Noodles)
    assertTrue(SateSauce(Peanuts(UdonNoodles())) is Noodles)
    assertTrue(SateSauce(Peanuts(WheatNoodles())) is Noodles)
    assertTrue(SateSauce(Pork(EggNoodles())) is Noodles)
    assertTrue(SateSauce(Pork(UdonNoodles())) is Noodles)
    assertTrue(SateSauce(Pork(WheatNoodles())) is Noodles)
    assertTrue(SateSauce(Tuna(EggNoodles())) is Noodles)
    assertTrue(SateSauce(Tuna(UdonNoodles())) is Noodles)
    assertTrue(SateSauce(Tuna(WheatNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Chicken(EggNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Chicken(UdonNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Chicken(WheatNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Peanuts(EggNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Peanuts(UdonNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Peanuts(WheatNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Pork(EggNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Pork(UdonNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Pork(WheatNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Tuna(EggNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Tuna(UdonNoodles())) is Noodles)
    assertTrue(TeriyakiSauce(Tuna(WheatNoodles())) is Noodles)
  }

  @Test
  fun `does not modify behavior`() {
    val eggNoodles = EggNoodles()
    val chickenEggNoodles = Chicken(eggNoodles)
    val bittersweetEggNoodles = BittersweetSauce(eggNoodles)
    assertTrue(eggNoodles.calculateCost() == chickenEggNoodles.calculateCost())
    assertTrue(eggNoodles.calculateCost() == bittersweetEggNoodles.calculateCost())
  }

  @Test
  fun `adds behavior`() {


  }

  @Test
  fun `is stackable`() {

  }
}
