package part4pm

object PatternMatching extends App {

  /*
  Pattern Matching:
  Is a way of checking the given sequence of tokens for the presence of the specific pattern
  It is a technique for checking a value against a pattern
  Similar to SWITCH STATEMENTS
  "match" keyword used instead of switch
  Contains a sequence of alternatives
  Each alternative will start from 'case' keyword
  Each case statement includes a pattern and one or more expression which get evaluated if the specific patterns gets matched.
  To separate the pattern from the expression (=>) is used
  */

  def test(x: Int) : String = x match {
    case 0 => "Hello Geeks"
    case 1 => "Are you enjoying Scala?"
    case 2 => "Keep it up!"
    case _ => "Don't give up"
  }

  println(x)




  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  // match is the keyword
  val description = x match {
    case 1 => "the ONE" // case statement
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else"  // _ = WILDCARD
  }

  // Trying to match a value against multiple patterns
  println(x) // prints 2 double or nothing
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US" // a < 21 is called a GUARD
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am" // WILDCARD always key - avoid errors
  }
  println(greeting)

  /*
    1. Cases are matched in order
    2. What if no cases match? >>> MatchError
    3. Type of the PM expression? >>> Unified type of all the types in all the cases
    4. PM works really well with case classes !!
   */

  // PM on Sealed Hierarchies - point 4
  sealed class Animal // help cover potential errors
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  // extractor pattern for a case classes
  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  // Match everything - don't use it for everything
  val isEven = x match {
    case  n if n % 2 == 0 => true
    case _ => false
  }
  // WHY?!
  val isEvenCond = if (x % 2 == 0) true else false // ?!
  val isEvenNormal = x % 2 == 0

  /*
    Exercise
    simple function uses PM
     takes an Expr => human readable form
     Sum(Number(2), Number(3)) => 2 + 3
     Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
     Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
     Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
   */
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))
}
