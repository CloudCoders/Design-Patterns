package oop.Visitor


interface PaymentMethodVisitable {
  fun accept(visitor: PaymentMethodVisitor)
}

sealed class PaymentMethod(var moneyPayed: Int, var cost: Int) : PaymentMethodVisitable {

  class CashPaymentMethod(moneyPayed: Float, cost: Float) :
    PaymentMethod((moneyPayed * 100).toInt(), (cost * 100).toInt()) {
    override fun accept(visitor: PaymentMethodVisitor) = visitor.visit(this)
  }

  class CreditCardPaymentMethod(cost: Float) : PaymentMethod((cost * 100).toInt(), (cost * 100).toInt()) {
    override fun accept(visitor: PaymentMethodVisitor) = visitor.visit(this)
  }

}
