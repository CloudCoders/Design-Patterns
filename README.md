# OOP Design Patterns and FP paradigm

## DONE 

### Creational patterns:

- [x] Abstract factory: Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

### Structural patterns:

- [x] Decorator:	Attach additional responsibilities to an object dynamically keeping the same interface. Decorators provide a flexible alternative to subclassing for extending functionality.

- [x] oop.Composite:	Compose objects into tree structures to represent part-whole hierarchies. oop.Composite lets clients treat individual objects and compositions of objects uniformly.

- [x] Facade:	Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

### Behavioral patterns:

- [x] Command: 	Encapsulate a request as an object, thereby allowing for the parameterization of clients with different requests, and the queuing or logging of requests. It also allows for the support of undoable operations.

- [x] Strategy: Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

## TODO

### Creational patterns:


	
- [ ] Builder:	Separate the construction of a complex object from its representation, allowing the same construction process to create various representations.
	
- [ ] Factory method:	Define an interface for creating a single object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses (dependency injection[19]).

- [ ] Lazy initialization:	Tactic of delaying the creation of an object, the calculation of a value, or some other expensive process until the first time it is needed. This pattern appears in the GoF catalog as "virtual proxy", an implementation strategy for the Proxy pattern.	Yes	No	PoEAA[20]

- [ ] Multiton:	Ensure a class has only named instances, and provide a global point of access to them.

- [ ] Object pool: Avoid expensive acquisition and release of resources by recycling objects that are no longer in use. Can be considered a generalisation of connection pool and thread pool patterns.

- [ ] Prototype: Specify the kinds of objects to create using a prototypical instance, and create new objects from the 'skeleton' of an existing object, thus boosting performance and keeping memory footprints to a minimum.

- [ ] Resource acquisition is initialization (RAII): Ensure that resources are properly released by tying them to the lifespan of suitable objects.

- [ ] Singleton: Ensure a class has only one instance, and provide a global point of access to it.

### Structural patterns:

- [ ] Adapter or Wrapper or Translator:	Convert the interface of a class into another interface clients expect. An adapter lets classes work together that could not otherwise because of incompatible interfaces. The enterprise integration pattern equivalent is the translator.

- [ ] Bridge:	Decouple an abstraction from its implementation allowing the two to vary independently.

- [ ] Extension object:	Adding functionality to a hierarchy without changing the hierarchy.	No	No	Agile Software Development, Principles, Patterns, and Practices[21]

- [ ] Flyweight:	Use sharing to support large numbers of similar objects efficiently.

- [ ] Front controller:	The pattern relates to the design of Web applications. It provides a centralized entry point for handling requests.

- [ ] Marker:	Empty interface to associate metadata with a class.	No	No	Effective Java[22]

- [ ] Module	Group several related elements, such as classes, singletons, methods, globally used, into a single conceptual entity.

- [ ] Proxy	Provide a surrogate or placeholder for another object to control access to it.
	
- [ ] Twin [23]	Twin allows modeling of multiple inheritance in programming languages that do not support this feature.

### Behavioral patterns:

//TODO ...
