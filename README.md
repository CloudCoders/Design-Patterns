Kotlin OOP and FP Design Patterns
=============
[![Build Status](https://travis-ci.org/CloudCoders/Design-Patterns.svg?branch=master)](https://travis-ci.org/CloudCoders/Design-Patterns)
[![Kotlin version badge](https://img.shields.io/badge/kotlin-1.1.1-blue.svg)](http://kotlinlang.org/)

## Index

* OOP
  * [Behavioral Patterns](#behavioral)
    * [x] [Chain of Responsability](#chain-of-responsability)
    * [x] [Command](#command)
    * [ ] [Interpreter](#interpreter)
    * [ ] [Iterator](#iterator)
    * [ ] [Mediator](#mediator)
    * [ ] [Memento](#memento)
    * [ ] [Null Object](#null-object)
    * [x] [Observer](#observer)
    * [x] [State](#state)
    * [x] [Strategy](#strategy)
    * [ ] [Template](#template)
    * [ ] [Visitor](#visitor)
  * [Creational Patterns](#creational)
    * [ ] [Abstract Factory](#abstract-factory)
    * [ ] [Builder](#builder)
    * [x] [Factory](#factory)
    * [ ] [Object Pool](#object-pool)
    * [ ] [Prototype](#prototype)
    * [x] [Singleton](#singleton)
  * [Structural Patterns](#structural)
    * [x] [Adapter](#adapter)
    * [ ] [Bridge](#bridge)
    * [x] [Composite](#brigde)
    * [x] [Decorator](#decorator)
    * [x] [Facade](#facade)
    * [ ] [Flyweight](#flyweight)
    * [x] [Proxy](#proxy)
* FP
  * [Monads](#monads)
    * [x] [Option/Maybe](#option)
    * [ ] Either
    
## Object oriented paradigm

Behavioral
==========

[Chain of Responsability](/src/main/kotlin/oop/ResponsabilityChain)
-----------------------

> It avoids coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. It pass the request along the chain until an object handles it.

This pattern is usually used within a [Composite](#composite)

### Example

```kotlin
interface MessageProcessor {
  fun process(message: Message): String
}

class UsernameProcessor(val next: MessageProcessor? = null): MessageProcessor {
  override fun process(message: Message): String = when (message) {
    is Message.Username -> message.message.toUpperCase()
    else -> next?.process(message) ?: message.message
  }
}

class PasswordProcessor(val next: MessageProcessor? = null): MessageProcessor {
  override fun process(message: Message): String = when (message) {
    is Message.Password -> message.message.map { '*' }.joinToString(separator = "")
    else -> next?.process(message) ?: message.message
  }
}

class PlainTextProcessor(val next: MessageProcessor? = null): MessageProcessor {
  override fun process(message: Message): String = when (message) {
    is Message.PlainText -> message.message
    else -> next?.process(message) ?: message.message
  }
}
```

### Usage

```kotlin
object ProcessingComposite : MessageProcessor {
  val bottom = PlainTextProcessor()
  val next = PasswordProcessor(bottom)
  val usernameProcessor = UsernameProcessor(next)
  
  override fun process(message: Message): String = usernameProcessor.process(message)
}

val password = Message.Password("SuperSecret")
val username = Message.Username("@Cotel")

println(ProcessingComposite.process(password))    // "***********"
println(ProcessingComposite.process(username))    // "@COTEL"
```

[Command](/src/main/kotlin/oop/Command)
-------

> It is an _object-oriented_ callback. Encapsulates a request as an object.
> It decouples the object that invokes the operation from the one that knows how to perform it.

### Example

```kotlin
interface Command {
  fun matches(command: String): Boolean
  fun execute()
}

class ChooseNoodlesCommand(val cart: Cart) : Command {
  companion object {
    val CHOOSE_NOODLES : String = "1"
  }
  
  override fun matches(command: String): Boolean = command == CHOOSE_NOODLES
  
  override fun execute() {
    cart.chooseNoodles()
  }
}

class Processor(val commands: List<Command>,
                val help: Command) {
                
  fun process(command: String): Command = 
    commands.filter { it.matches(command) }.getOrElse(0) { help } 
    
}
```

### Usage

```kotlin
val scanner = Scanner(System.`in`)
val cart = Cart(scanner)
val commands = listOf(
  ChooseNoodlesCommand(cart),
  // ...
)
val proc = Proccessor(commands, CommandNotFound())

var commandChoice = -1
do {

  commandChoice = scanner.nextInt()
  proc.proccess("$commandChoice").execute()
  
} while (commandChoice != 0)

```

Interpreter
----------

> Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language

**In progress**

Iterator
--------

> It provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation

**In progress**

Mediator
---------

> Define an object that encapsulates how a set of objects interact. It designs an intermediary to decouple many peers.

**In progress**

Memento
---------

> It captures and externalizes an object's internal state so it can get back to this state later without violating encapsulation

**In progress**

Null Object
-----------

> It encapsulates the absence of an object by providing an alternative that offers suitable default behaviour for doing nothing.
> Useful to abstract the handling of null away from the client

**In progress**

[Observer](/src/main/kotlin/oop/Observer)
------------

> It defines a _one-to-many_ dependency between object so that when one changes its state, all its dependents are notified and updated automatically.

In Kotlin, this pattern is extremely easy to implement thanks to [property delegation](https://kotlinlang.org/docs/reference/delegated-properties.html)

### Example

```kotlin
interface Observer<in T> {
  fun onValueChange(newValue: T, oldValue: T)
}

class CustomersObserver : Observer<Int> {
  override fun onValueChange(newValue: Int, oldValue: Int) = when {
    newValue > oldValue -> println("A new customer entered. Current customers $newValue")
    else -> println("A customer left. Current customers: $newValue")
  }
}

class Shop(private val observer: Observer<Int>) {
  var currentCustomers by Delegates.observable(0) { _, old, new ->
    observer.onValueChange(new, old)
  }
}
```

### Usage

```kotlin
shop.currentCustomers++ // prints "A new customer entered ..."
shop.currentCustomers-- // prints "A customer left ..."
```

[State](/src/main/kotlin/oop/State)
-------

> It allows an object to alter its behaviour when its internal state changes.

We can use Kotlin's [sealed classes](https://kotlinlang.org/docs/reference/sealed-classes.html) to define a restricted hierarchy so that the current _State_ can only have limited values from a set.

### Example

```kotlin
interface State {
  fun next(): State
}

sealed class SemaphoreStates : State {
  object Red : SemaphoreStates() {
    override fun next() = Green
  }

  object Green : SemaphoreStates() {
    override fun next() = Yellow
  }

  object Yellow : SemaphoreStates() {
    override fun next() = Red
  }
}

class Semaphore(startingState: State = SemaphoreStates.Red) {
  var state = startingState
    private set

  fun nextLight() {
    state = state.next()
  }
}
```

### Usage

```kotlin
fun Semaphore.canICross() = this.state is SemaphoreStates.Green 

val semaphore = Semaphore()

println(semaphore.canICross()) // false

semaphore.nextLight()

println(semaphore.canICross()) // true
```

[Strategy](/src/main/kotlin/oop/Strategy)
---------

> Define a family of algorithms, encapsulate each one, and make them interchangeable. It captures the abstraction in an interface and buries implementation details in derived classes.

In Kotlin, we can implement this pattern with only functions because of the support for first order functions.

### Example

```kotlin
val GeneralStrategy : (Double) -> Double = { it + it * 0.21 }

val ReducedStrategy : (Double) -> Double = { it + it * 0.10 }

val SuperReducedStrategy = { cost: Double -> cost + cost * 0.04 } // Alternative way to define it

```

### Usage

```kotlin
var ivaStrategy = GeneralStrategy  // You can change the strategy in execution time
val price = 3.14

println(ivaStrategy(price))

```

Template
---------

> Define an skeleton of an algorithm in an operation, deferring some steps to client subclasses. These subclasses can redefine certain steps of an algorightm without changing its structure

**In progress**

Visitor
------

> Represent an operation to be performed on the elements of an object structure. It lets you define a new operation without changing the classes of the elements on which it operates.

**In progress**

Creational
==========

Abstract Factory
----------------

> It provides an interface for creating families of related dependents objects without specifying their concrete classes

**In progress**

Builder
---------

> It separates the construction of a complex object from its representation so that the same construction process can create different representations.

**In progress**

[Factory](/src/main/kotlin/oop/Factory)
--------

> It defines an interface for creating an object, but let subclasses decide which class to instantiate.

### Example
```kotlin
class NoodlesFactory {
  fun getNoodles(noodleType: Int): Noodles {
    when (noodleType) {
      1 -> return EggNoodles()
      2 -> return UdonNoodles()
      3 -> return WheatNoodles()
      else -> throw NoNoodlesMatchException()
    }
  }
}

```

### Usage

```kotlin
val scanner = Scanner(System.`in`)
val noodlesFactory = NoodlesFactory()

val noodlesType = scanner.nextInt()
val noodles = noodlesFactory.getNoodles(noodlesType)
```

Object Pool
-----------

> An Object Pool can offer a significant performance boost, it is most effective in situations where the cost of initializing a class instance is high.

**In progress**

Prototype
-----------

> It specifies the kind of objects to create using a prototypical instance and create new objects by copying this instance.

**In progress**

Singleton
---------

> It ensures a class has only one instance and provide a global point of access to it.

In Kotlin we can make use of the reserved keyword `Object`

### Example

```kotlin
object OneInstance {

  fun sayHello() = println("Hello")

}

```

### Usage

```kotlin
OneInstance.sayHello()
```

Structural
==========

[Adapter](/src/main/kotlin/oop/Adapter)
--------

> It converts an interface of a class into another interface clients expect. It lets classes work together that couldn't otherwise.

### Example
We're going to adapt a U.S robot interface that uses miles per hour and feet (Imperial system) to a European interface that employs Km/h and meters (Metric system).

```kotlin
interface USRobotsAdaptee{
  var speedInMilesPerHour: Double
  fun enableFirstLawMode()
  fun jump(feet: Double)
}

interface EuropeanRobotTarget
{
  var speedInKilometersPerHour: Double
  fun jump(meters: Double)
}

class USRobot(override var speedInMilesPerHour: Double = 0.0) :USRobotsAdaptee{
  override fun enableFirstLawMode() {
    println("Partial first law enabled")
  }

  override fun jump(feet: Double) {
    println("JUMPED $feet feet")

  }
  
data class EURobotAdapter(var usRobot: USRobot) : EuropeanRobotTarget{
  override var speedInKilometersPerHour: Double
    get() = usRobot.speedInMilesPerHour * 1.6093
    set(value) {usRobot.speedInMilesPerHour = value * 0.62137}



  override fun jump(meters: Double) {
    usRobot.jump(meters * 0.3048)
  }


```

### Usage

```kotlin
val euRobot = EURobotAdapter(USRobot())
euRobot.speedInKilometersPerHour = 3.4

println("Current speed in KM/h: ${euRobot.speedInKilometersPerHour}")
euRobot.jump(12.5)
```



Bridge
------

> It decouples an abstraction from its implementation so that the two can vary independently.

**In progress**

[Composite](/src/main/kotlin/oop/Composite)
--------

> Compose objects into tress structures to represent whole-part hierarchies. It lets clients treat individual objects and compositions uniformly.

### Example

```kotlin
interface Cooker {
  fun cook()
}

interface ChineseCooker(private val cookers: MutableList<Cooker> = mutableListOf()): Cooker {
  fun add(cooker: Cooker) = cookers.add(cooker)
  
  override fun cook() {
    println("Cooking plate with soy sauce")
    cookers.forEach(Cooker::cook)
  }
}

interface DeepFryer(): Cooker {
  override fun cook() {
    println("And frying")
  }
}

class Kitchen(private val cookers: MutableList<Cooker> = mutableListOf()): Cooker {
  fun add(cooker: Cooker) {
    cookers.add(cooker)
  }
  
  fun remove(cooker: Cooker) {
    cookers.remove(cooker)
  }
  
  override fun cook() {
    cookers.forEach(Cooker::cook)
  }
}

```

### Usage

```kotlin
val chinese = ChineseCooker()
chinese.add(DeepFryer())

val cookers = mutableListOf(chinese)
val kitchen = Kitchen(cookers)
kitchen.cook()
```

[Decorator](/src/main/kotlin/oop/Decorator)
----------

> It attachs additional responsabilities to an object dynamically.

In Kotlin, we don't need to redefine the methods of the decorated interface. We can use `by` to [delegate](https://kotlinlang.org/docs/reference/delegation.html) those methods to the decorated class.

### Example

```kotlin
interface Noodles {
  fun calculateCost(): Double
}

class UdonNoodles : Noodles {
  override fun calculateCost() = 3.50
}

abstract class SauceDecorator(private val noodles: Noodles): Noodles by noodles {
  abstract val SPICINESS: Int
}

class RedPepperSauce(noodles: Noodles): SauceDecorator(noodles) {
  override val SPICINESS: Int = 3
}
```
### Usage

```kotlin
val udonNoodles = UdonNoodles()
val udonNoodlesWithRedPepperSauce = RedPepperSauce(udonNoodles)

println(udonNoodlesWithRedPepperSauce.calculateCost()) // 3.50
println(udonNoodlesWithRedPepperSauce.SPICINESS) // 3
```

[Facade](/src/main/kotlin/oop/Facade)
----------

> It provides a unified interface to a set of interfaces in a subsystem.

### Example

```kotlin
class NetInvoiceSalaryFacade(val iva: IVAOperation = IVAOperation(),
                             val irpf: IRPFOperation = IRPFOperation()) {
  fun calculate(salary: Double): Double =
    salary + iva.apply(salary) - irpf.apply(salary)
    
  fun calculateAnnual(monthlySalary: Double): Double = 
    calculate(monthlySalary * 12)
}

class IVAOperation {
  fun apply(amount: Double): Double = amount + (amount * 0.21)
}

class IRPFOperation {
  fun apply(amount: Double): Double = amount + (amount * 0.15)
}
```

### Usage

```kotlin
val facade = NetInvoiceSalaryFacade()
println(facade.calculateAnnual(1000))
```

Flyweight
----------

> It uses sharing to support large numbers of fine-grained objects efficiently

**In progress**

[Proxy](/src/main/kotlin/oop/Proxy)
------

> It provides a placeholder for another object to control access to it.
> It is an extra level of indirection to support controlled or intelligent access.

There are 3 types of Proxies

* [Protection Proxy](#protection-proxy) - Which control the access to an object.
* [Virtual Proxy](#virtual-proxy) - Which prevents creating an object until it is really necessary to save resources.
* [Remote Proxy](#remote-proxy) - Which duty is to create a correct request to ask a remote real object which may not be in our domain.

Protection proxy
-------

### Example

```kotlin
class Transaction(val amount: Double,
                  val isInternational: Boolean)

interface Payment {
  fun pay(transaction: Transaction)
}

class PaymentProtectionProxy(private val payment: Payment): Payment {
  override fun pay(transaction: Transaction) {
    if (transaction.isInternational) println("Payment is international, we do not allow it")
    else payment.pay(transaction)
  }
}

class RealPayment(val initialAmount: Double): Payment {
  override fun pay(transaction: Transaction) {
    initialAmount -= transaction.amount
    println("Successful!")
  }
}
```

### Usage

```kotlin
val account = RealPayment(100.0)
val localBank = PaymentProtectionProxy(account)

localBank.pay(Transaction(3.15, true)) // It won't allow us to pay
localBank.pay(Transaction(3.15, false)) // It will work
```

Virtual Proxy
------------

We can use kotlin's [lazy delegation](https://kotlinlang.org/docs/reference/delegated-properties.html#lazy)

### Example

```kotlin
interface Screen {
  fun show()
}

class VirtualScreen(val screenCreation: () -> Screen) : Screen {
  private val realScreen: Screen by lazy {
    screenCreation()
  }
  
  override fun show() {
    realScreen.show()
  }
}

class RealScreen : Screen {
  constructor() {
    // It gets really hungry in here
  }
  
  override fun show() {
    println("¯\_(ツ)_/¯")
  }
}
```

### Usage

```kotlin
val virtualScreen = VirtualScreen({ RealScreen() })  // We haven't created a RealScreen yet

// Several lines after...

virtualScreen.show()  // RealScreen is needed now, so we create it

```

Remote Proxy
----------

### Example

```kotlin
// Client code

interface Message {
  fun writeInChannel(text: String, channel: String)
}

class MessageProxy(private val outpuStream: OutputStream) : Message {
  override fun writeInChannel(text: String, channel: String) {
    outpuStream.write("Headers:$text:$channel:Goodbye")
  }
}

// Server code

class ServerMessage(val channels: List<Channel>) : Message {
  override fun writeInChannel(text: String, channel: String) {
    channels.forEach {
      if (it == channel) {
        println("$text")
      }
    }
  }
}

class Server {
  val channels = listOf("1", "2", "3")
  val messageHandler = ServerMessage(channels)
  
  fun onClientMessage(request: String) {
    val (message, channel) = request
      .removePrefix("Headers:")
      .removeSuffix(":Goodbye")
      .split(":")
      
    messageHandler.writeInChannel(message, channel)                  
  }
}
```

## Functional paradigm

Monads
========

[Option](/src/main/kotlin/fp/Maybe) AKA Maybe
------

> It represents a value which is of type _A_ or none.

### Example

```kotlin
sealed class Maybe<A> {
  companion object {
    fun <A: Any> fromNullable(a: A?): Maybe<A> = if (a != null) Maybe.Just(a) else Maybe.None
  }
  
  abstract val isEmpty: Boolean
  
  fun <B> fold(ifEmpty: () -> B, fn: (A) -> B): B = when (this) {
    is Maybe.None -> ifEmpty()
    is Maybe.Just -> fn(value)
  }
}

fun <B> Maybe<B>.getOrElse(default: () -> B): B = fold({ default() }, { it })
```

### Usage

```kotlin
val returnExplanatoryString: () -> String = { "Result is null" }
val listOfCountries = listOf("Spain", "France", "Italy")
val getValueInList: (String) -> (List<String>) -> String? = { item -> 
  {
    list -> list.find { it == item }
  }
}
val getTanzaniaInList = getValueInList("Tanzania")

val maybeTanzania = Maybe.fromNullable(getTanzaniaInList(listOfCountries))

val country = maybeTanzania
  .map(String::toUpperCase)
  .getOrElse(returnExplanatoryString)
val countryClassic = listOfCountries.find { it == "Tanzania" }?.toUpperCase()

println(country)        // This won't be null
println(countryClassic) // This can be null

```


