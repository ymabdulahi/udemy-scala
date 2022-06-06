package part2oop

// refer to Inheritance file as well
object AbstractDataTypes extends App {

  // Abstract - when you need to leave fields and methods blank or unimplemented
  // abstract keyword
  // you want the subclasses to do that for you
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  // correct way to extend an abstract class - by using override
  // you don't need to use override if hasn't been defined in the original abstract class
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // TRAITS - IMPORTANT TO ABSTRACT CLASSES
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded // you can mix in as many traits as you want

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // TRAITS v ABSTRACT
  // Can both contain abstract and non-abstract members
  // 1. Traits DO NOT have constructor parameters
  // 2. You can extend ONE class (single class inheritance), but inherit MULTIPLE traits
  // 3. Traits = behaviour e.g. Carnivore, Coldblooded
  // 4. Class = type of "thing" e.g. Crocodile is a type of Animal


}
