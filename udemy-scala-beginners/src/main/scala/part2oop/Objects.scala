package part2oop

object Objects {

  // class level functionality - previous lesson on classes + method notations
  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static") - object
  // Equivalent to static in Scala would be object
  // Objects do not receive parameters
  object Person { // define the type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Joseph")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS - reside in the same scope and have the same name


  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // SCALA OBJECT = SINGLETON INSTANCE by definition
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    // can use apply() or just Person() singleton object callable to both mary and john
    val joseph = Person(mary, john)

    // Scala applications = Scala object with
    // def main(args: Array[String]): Unit
    // if you remove extends App - and use this - the code becomes runnable
  }
}

/*
 TAKEWAYS:
Scala doesn't have "static" values/methods

Scala objects:
- are in their own class
- are the only instance
- singleton pattern in one line!

Scala companions - both the object and class can exist in the same scope
- can access each other's private members
- Scala is more OO than Java!

Scala applications - def main args // extends App
*/