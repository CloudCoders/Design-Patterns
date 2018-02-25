import oop.Strategy.strategies.*
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Test

class IVAStrategyTest{

  @Test
  fun `check that general iva is applied correctly`(){
    assertThat(generalStrategy(2.0), CoreMatchers.`is`(2.42))
  }

  @Test
  fun `check that reduced iva is applied correctly`(){
    assertThat(reducedStrategy(2.0), CoreMatchers.`is`(2.2))
  }

  @Test
  fun `check that super-reduced iva is applied correctly`(){
    assertThat(superReducedStrategy(2.0), CoreMatchers.`is`(2.08))
  }
}
