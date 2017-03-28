package oop.Facade

class InvoiceFacade(val iva: IVAOperation,
                    val irpf: IRPFOperation) {

  fun calculate(salary: Double) : Double {
    return salary + iva.apply(salary) - irpf.apply(salary)
  }

}

class IVAOperation {

  fun apply(amount: Double) : Double = amount + (amount * 0.21)
}

class IRPFOperation {

  fun apply(amount: Double) : Double = amount + (amount * 0.15)

}

