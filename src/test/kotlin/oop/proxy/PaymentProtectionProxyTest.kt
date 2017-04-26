package oop.proxy

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test


class PaymentProtectionProxyTest {

  @Test
  fun `pay transaction success`() {
    var realPayment = RealPaymentMock()
    val protectionProxy = PaymentProtectionProxy(realPayment)

    protectionProxy.pay(Transaction(100.0, false))

    assertTrue(realPayment.callPay)
  }

  @Test
  fun `pay transaction failure if international`() {
    var realPayment = RealPaymentMock()
    val protectionProxy = PaymentProtectionProxy(realPayment)

    protectionProxy.pay(Transaction(100.0, true))

    assertFalse(realPayment.callPay)
  }

  class RealPaymentMock(var callPay: Boolean = false) : Payment {

    override fun pay(transaction: Transaction) {
      callPay = true
    }

  }

}
