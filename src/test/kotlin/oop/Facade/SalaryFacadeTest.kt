package oop.Facade

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class SalaryFacadeTest {

  @Test
  fun `should calculate SALARY + IVA - RETENTION when 550 + 115,5 + 82,50 = 583`(){
    val invoiceSalaryCalculator = NetInvoiceSalaryFacade(IVAOperation(), IRPFOperation())

    assertThat(invoiceSalaryCalculator.calculate(550.0), `is`(583.0))
  }

  @Test
  fun `should calculate annual salary like monthly net salary * 12`(){
    val invoiceSalaryCalculator = NetInvoiceSalaryFacade(IVAOperation(), IRPFOperation())

    assertThat(invoiceSalaryCalculator.calculateAnnual(550.0), `is`(6996.0))
  }
}
