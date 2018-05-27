package oop.Visitor


interface PaymentMethodVisitor {
  fun visit(paymentMethod: PaymentMethod.CashPaymentMethod)
  fun visit(paymentMethod: PaymentMethod.CreditCardPaymentMethod)
}

class CashRegister(initialAmount: Float) : PaymentMethodVisitor {

  var cash = (initialAmount * 100).toInt()
    private set

  override fun visit(paymentMethod: PaymentMethod.CashPaymentMethod) {
    cash += paymentMethod.moneyPayed
    cash -= (paymentMethod.moneyPayed - paymentMethod.cost)
    paymentMethod.moneyPayed = (paymentMethod.moneyPayed - paymentMethod.cost)
  }

  override fun visit(paymentMethod: PaymentMethod.CreditCardPaymentMethod) {
    cash += paymentMethod.cost
    paymentMethod.moneyPayed = 0
  }

}
