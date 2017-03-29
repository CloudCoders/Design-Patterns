package oop.Facade

class NetInvoiceSalaryFacade(val iva: IVAOperation,
                             val irpf: IRPFOperation) {

  fun calculate(salary: Double) : Double =
    salary + iva.apply(salary) - irpf.apply(salary)

  fun calculateAnnual(monthlySalary: Double) : Double =
    calculate(monthlySalary * 12)

}

class IVAOperation {

  fun apply(amount: Double) : Double = amount + (amount * 0.21)
}

class IRPFOperation {

  fun apply(amount: Double) : Double = amount + (amount * 0.15)

}

