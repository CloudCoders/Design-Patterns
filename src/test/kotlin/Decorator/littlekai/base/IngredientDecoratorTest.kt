package Decorator.littlekai.base

import Decorator.littlekai.ingredients.Chicken
import Decorator.littlekai.ingredients.Peanuts
import Decorator.littlekai.ingredients.Pork
import Decorator.littlekai.ingredients.Tuna
import Decorator.littlekai.noodles.EggNoodles
import Decorator.littlekai.sauces.BittersweetSauce
import org.junit.Assert.assertTrue
import org.junit.Test

class IngredientDecoratorTest {

  @Test
  fun `has the same interface`() =
    assertTrue(BittersweetSauce(Chicken(EggNoodles())) is Noodles)

  @Test
  fun `does not modify behavior`() =
    assertTrue(EggNoodles().calculateCost() == BittersweetSauce(Chicken(EggNoodles())).calculateCost())

  @Test
  fun `adds behavior`() =
    assertTrue(Chicken(EggNoodles()).calculateTotalCost() == EggNoodles().calculateCost() + Chicken(EggNoodles()).COST)

  @Test
  fun `is stackable`() =
    assertTrue(
      Tuna(Pork(Peanuts(Chicken(EggNoodles())))).calculateTotalCost() ==
        EggNoodles().COST +
        Chicken(EggNoodles()).COST +
        Peanuts(EggNoodles()).COST +
        Pork(EggNoodles()).COST +
        Tuna(EggNoodles()).COST)
}
