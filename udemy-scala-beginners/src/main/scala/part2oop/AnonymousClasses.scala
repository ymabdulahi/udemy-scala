package part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Instantiating an abstract class
  // A real class
  // This is ANONYMOUS CLASS
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("laugh out loud")

    println(funnyAnimal.getClass)

    // prints out class lectures.part2oop.AnonymousClass$$anon$1
  }

  /*
  SAME AS ABOVE - DOES THIS BEHIND THE SCENE

  class AnonymousClasses$$anon$1 extends Animal {
  override def eat: Unit = println("laugh out loud)
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1

  println(funnyAnimal.getClass)
  */

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  // need to pass through the correct parameters, when extending from superclasses
  // it works for abstract and non abstract data types
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }

  // TAKEAWAYS
  /*
  - We can instantiate types and override fields or methods on the spot e.g.

  trait Animal {
  def eat: Unit
  }

  val predator = new Animal {
  override def eat: Unit = println("rawr!")
  }

  RULES TO FOLLOW:
  1. Pass in required constructor arguments if needed
  2. Implement all abstract fields/methods

  - Works for traits and classes (abstract or not)
  */


}
