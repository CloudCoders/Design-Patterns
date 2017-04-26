package oop.proxy

interface Payment {
  fun pay(transaction: Transaction)
}

class PaymentProxy(private val realPayment: Payment) : Payment {

  override fun pay(transaction: Transaction) {
    if (!transaction.isInternational){
      realPayment.pay(transaction)
    } else {
      println("Can't pay international transactions")
    }
  }
}

class RealPayment(var amount: Double) : Payment {

  override fun pay(transaction: Transaction) {
    amount -= transaction.amount
    println("Real payment successful")
  }

}

class Transaction(val amount: Double,
                  val isInternational: Boolean)
