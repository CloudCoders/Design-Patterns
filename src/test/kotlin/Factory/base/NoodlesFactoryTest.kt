package Factory.base

import Decorator.littlekai.noodles.EggNoodles
import org.junit.Assert.assertTrue
import org.junit.Test

class NoodlesFactoryTest {

  @Test
  fun `if parameter is 1 should return EggNoodles `() {
    val factory = NoodlesFactory()
    assertTrue(factory.getNoodles(1) is EggNoodles)
  }

  @Test(expected = NoNoodlesMatchException::class)
  fun `if parameter is not in range should throw NoNoodlesMatchException`() {
    val factory = NoodlesFactory()
    factory.getNoodles(100)
  }

}
