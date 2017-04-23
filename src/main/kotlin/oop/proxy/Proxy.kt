package oop.proxy

interface Payment {
  fun pay(amount: Double)
}

class PaymentProxy(private val realPayment: Payment) : Payment {

  override fun pay(amount: Double) {
    realPayment.pay(amount)
  }
}

class RealPayment(private var initAmount: Double) : Payment {
  override fun pay(amount: Double) {
    initAmount -= amount
  }

}

