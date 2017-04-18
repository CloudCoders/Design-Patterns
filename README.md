# Kotlin OOP and FP Design Patterns

## Index

* OOP
  * [Behavioral Patterns](#behavioral)
    * [ ] Chain of Responsability
    * [x] Command
    * [ ] Interpreter
    * [ ] Iterator
    * [ ] Mediator
    * [ ] Memento
    * [ ] Null Object
    * [ ] Observer
    * [ ] State
    * [ ] Template
    * [ ] Visitor
  * Creational Patterns
    * [ ] Abstract Factory
    * [ ] Builder
    * [x] Factory
    * [ ] Object Pool
    * [ ] Prototype
    * [x] Singleton
  * Structural Patterns
    * [ ] Adapter
    * [ ] Bridge
    * [x] Composite
    * [x] Decorator
    * [x] Facade
    * [ ] Flyweight
    * [ ] Proxy
* FP
  * Monads
    * [x] Option/Maybe
    * [ ] Either

Behavioral
==========

Chain of Responsability
-----------------------

> It avoids coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. It pass the request along the chain until an object handles it.

**In progress**

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

Observer
------------

> It defines a _one-to-many_ dependency between object so that when one changes its state, all its dependents are notified and updated automatically.

**In progress**

State
-------

> It allows an object to alter its behaviour when its internal state changes.

**In progress**

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

To be completed...
