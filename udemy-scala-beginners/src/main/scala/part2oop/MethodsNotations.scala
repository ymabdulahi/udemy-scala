package part2oop

object MethodsNotations extends App {

  class Person (val name: String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
  }

  // SYNTACTIC SUGARS - more resemblance of natural language

  val yonis = new Person("Yonis", "Inception")
  println(yonis.likes("Inception"))
  println(yonis likes "Inception") // equivalent to the method above
  // Infix notation = operator notation - only works with methods that have 1 parameter

  // "operators" in Scala - reminisce of actual operators - so hangOutWith can be replaced with + sign so can be def +()
  val mohamed = new Person("Mohamed", "Fight Club")
  println(yonis hangOutWith mohamed)
  // println(yonis + mohamed) = output would still be 'Yonis is hanging out with Mohamed'
  // this is a valid expression

  // ALL OPERATORS ARE METHODS!
  // Akka actors have ! ?

  // Prefix Notations
  // Unary methods
  val x = -1 // equivalent with 1.unary_-
  // unary_prefix only works with - + ~ !
  println(!yonis)
  println(yonis.unary_!)
  // these are equivalent

  // Postfix Notations
  println(yonis.isAlive)
  // println(yonis isAlive) same as the above


  // APPLY (SPECIAL METHOD)
  println(yonis.apply())
  println(yonis()) // equivalent - call it as if it was a function because of apply() method in the person class

}
