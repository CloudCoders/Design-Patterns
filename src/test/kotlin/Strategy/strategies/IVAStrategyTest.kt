import Strategy.strategies.*
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Test

class IVAStrategyTest{

  @Test
  fun `check that general iva is applied correctly`(){
    assertThat(GeneralStrategy(2.0), CoreMatchers.`is`(2+2*0.21))
  }

  @Test
  fun `check that reduced iva is applied correctly`(){
    assertThat(ReducedStrategy(2.0), CoreMatchers.`is`(2+2*0.1))
  }

  @Test
  fun `check that super-reduced iva is applied correctly`(){
    assertThat(SuperReducedStrategy(2.0), CoreMatchers.`is`(2+2*0.04))
  }
}
