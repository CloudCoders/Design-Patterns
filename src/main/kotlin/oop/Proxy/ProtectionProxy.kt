package oop.Proxy

interface Car {
  fun isNovel(): Boolean
  fun drive()
}

class CarProtectionProxy(private val realObject: Car) : Car {
  override fun drive() {
    if (!realObject.isNovel()) {
      realObject.drive()
    } else {
      println("You can't drive a car")
    }
  }

  override fun isNovel(): Boolean = realObject.isNovel()
}

class CarVirtualProxy(private val create: () -> Car) : Car {

  private val realObject by lazy {
    create()
  }

  override fun drive() = realObject.drive()

  override fun isNovel(): Boolean = realObject.isNovel()
}

class CarSmartProxy(private val realObject: Car,
                    var accesDriver: Int = 0) : Car {

  override fun drive() {
    realObject.drive()
    accesDriver++
  }

  override fun isNovel(): Boolean = realObject.isNovel()
}

class RealCar(val name: String, val driverAge: Int) : Car {
  override fun drive() = println("$name is driving a car")

  override fun isNovel(): Boolean = driverAge < 18
}

fun main(args: Array<String>) {


  var carVirtualProxy = CarVirtualProxy({ RealCar("tonilopezmr", 5) })
  var carProtectionProxy = CarProtectionProxy(carVirtualProxy)
  var carSmartProxy = CarSmartProxy(carVirtualProxy)

  //Subject or Client usa el proxy

  carProtectionProxy.drive()
  carSmartProxy.drive()

  println("Toni has driven ${carSmartProxy.accesDriver} times")




}

interface Payment {
  fun pay(transaction: Transaction)
}

class PaymentProtectionProxy(private val realPayment: Payment) : Payment {

  override fun pay(transaction: Transaction) {
    if (!transaction.isInternational) {
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
