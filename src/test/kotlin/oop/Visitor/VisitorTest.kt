package oop.Visitor

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.assertion.assert
import org.junit.Test

class VisitorTest {

  val `is` = { amount: Number -> Matcher(Number::equals, amount) }
  fun Int.toMoney() = this.div(100f)

  @Test
  fun `cash should increment exact amount when payment is credit card`() {
    val cashRegister = CashRegister(0f)
    val creditCard = PaymentMethod.CreditCardPaymentMethod(15.50f)

    cashRegister.visit(creditCard)

    assert.that(cashRegister.cash.toMoney(), `is`(15.50f))
  }

  @Test
  fun `moneyPayed should be 0 when payment is credit card after payment`() {
    val cashRegister = CashRegister(0.0f)
    val creditCard = PaymentMethod.CreditCardPaymentMethod(15.50f)

    cashRegister.visit(creditCard)

    assert.that(creditCard.moneyPayed.toMoney(), `is`(0.0f))
  }

  @Test
  fun `cash should increment payedAmount and decrease exchange amount when payment is cash`() {
    val cashRegister = CashRegister(0.0f)
    val cash = PaymentMethod.CashPaymentMethod(20.0f, 19.99f)

    cashRegister.visit(cash)

    assert.that(cashRegister.cash.toMoney(), `is`(19.99f))
  }

  @Test
  fun `moneyPayed should be equal to exchange when payment is cash`() {
    val cashRegister = CashRegister(0.0f)
    val cash = PaymentMethod.CashPaymentMethod(20.0f, 19.99f)

    cashRegister.visit(cash)

    assert.that(cash.moneyPayed.toMoney(), `is`(0.01f))
  }


}
