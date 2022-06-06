package part2oop

object Inheritance extends App {

  // Single Class Inheritance
  // can use private e.g. private def eat - means it can only be used in Animal
  // protected modifier allows the use of method eat in the sub class - not accessible outside the class
  // public is just default - no need to write it out
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  // def protected eat - allows it to be called inside the class - not outside
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.eat

  // constructors
  // need to pass parameters when extending from the constructor
  // Person is the super class
  class Person(name: String, age: Int) {
    // define auxiliary constructor
    def this(name: String) = this(name, 0)
  }

  // don't need age parameter passed because of the auxiliary constructor above in the extends clause
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overRIDING
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType = "domestic" // this can be passed as a class parameter
    override def eat = {
      // if you want to use main method from parent class - refer to method in super class
      super.eat
      println("yam, yam")
    }
  }

  // if passed in the class parameter then need to define the String when instantiating
  val dog = new Dog ("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  // uses the overridden implementation of eat - go to the most override version
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // DISTINCTION TO BE MADE BETWEEN:
  // overRIDING - means supplying a different implementation in derived classes
  // overLOADING - supplying multiple methods with different signatures with the same name in the same class

  // super - used when you want to reference a method from a parent class

  // preventing overrides
  // 1. use keyword FINAL on member e.g. final def eat = println("nomnom") from parent class
  // FINAL will prevent it from being overridden

  // 2. final class Animal (on entire class) - prevents the entire class from being overridden
  // extension of CAT and Dog won't work

  // 3. seal the class - softer restriction - can extend classes in this FILE but prevents extentsions in other files
  // sealed class Animal (sealed keyword)
}
