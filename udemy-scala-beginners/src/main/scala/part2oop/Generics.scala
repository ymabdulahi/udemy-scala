package part2oop

object Generics extends App {

  // Generic classes take a type like a parameter inside square brackets
  // They are utilised explicitly for the progress of the collection classes
  // Have two list types, A and B then List[A] is sub-type of List[B] if only type B is equivalent to type A
  // MyList is an abstract type
  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    // technically an invariant list
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // Variance problem
  // (don't stress about it)
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Question > If Cat extends Animal, does a List of Cat also extend a List of Animal

  // 1. Yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A] // how you declare covariance put the +A - cats are animals
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // similar to polymorphism
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals

  // 2. NO = INVARIANCE
  // List of cats and animals are two different lists
  class InvariantList[A] // how you declare an invariant list - regular A
  // can't substitute a new list of variant so animal = animal
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A] // how you declare a contravariant class - use -A - ContravariantList[-A] - list of animal would have to replace list of cats even though cats are animals too
  // opposite relation to covariance
  // semantics - if you change it to trainer, makes more sense cos a Trainer of Animals can also train a Cat
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded types - allowed to use generic classes if its subclass or superclass of a different type
  class Cage[A <: Animal](animal: A) // <: is a restriction - only accepts subtypes of Animals of type A (list)
                                    // >: would accept if it was a supertype of Animal 
  val cage = new Cage(new Dog)

  class Car
  // generic type needs proper bounded type
  //  val newCage = new Cage(new Car)

  // expand MyList to be generic
}
