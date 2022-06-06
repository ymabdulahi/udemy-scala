package part2oop

object CaseClasses extends App {

  // equals, hashCode, toString etc
  // Ideal solution - shorthand for defining a class and companion object and sensible defaults in one

  case class Person(name: String, age: Int)

  // 1. Class parameters are fields
  val yonis = new Person("Yonis", 25)
  println(yonis.name)

  // 2. Sensible toString
  // println(yonis) prints the same - syntactic sugar for println(instance) = println(instance.toString)
  println(yonis.toString) // Person(Yonis, 25) in console

  // 3. equals and hashCode implemented OUT OF THE BOX
  // prints - returns false
  val mohamed = new Person("Mohamed", 27)
  println(yonis == mohamed)

  // 4. CC's have handy copy methods
  // also received name parameters - and returns different parameters
  // val yonis2 = yonis.copy(age = 35)
  val yonis2 = yonis.copy()
  println(yonis2)

  // 5. CC's have companion objects
  // Person is the valid companion of this case class
  // case keyword automatically make the companion valid
  val thePerson = Person
  // factory methods
  // can call the apply method - make it callable like a function
  // can easily construct a person
  val mary = Person("Taqwah", 16)

  // 6. CCs are serializable
  // Important with Akka - sending serializable messages through the network

  // 7. CCs have extractor patterns
  // Can be used in PATTERN MATCHING

  // CASE OBJECTS - case acts like an object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  TAKEAWAYS:
  - Quick lightweight data structures with little boilerplate
  case class Person(name: String, age: Int)

  - Companions already implemented
  val bob = Person("Bob", 26)

  - Sensible equals, hashCode, toString

  - Auto-promoted params to fields
  bob.name

  - Cloning

  - case objects
  */
}
