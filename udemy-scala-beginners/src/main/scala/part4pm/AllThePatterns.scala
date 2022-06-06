package part4pm
import scala.util.*
import scala.collection.immutable.TreeSeqMap.Empty

object AllThePatterns extends App {
  // 1 - Constants - any literal
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - Match Anything
  // 2.1 Wildcard
  val matchAnything = x match {
    case _ => // returns whatever - case important for wildcard
  }

  // 2.2 Variable - use the value that was extracted in the return expression
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - Tuples - simple data structure
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1, 1) => // pass in a literal tuple - tuple of literals
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  // PMs can be NESTED!

  // 4 - Case classes - Constructor pattern
  // PMs can be nested with CCs as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) => // will bind the values extracted from the list // also be nested
  }

  // 5 - List patterns - powerful
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1,2,_) :+ 42 => "lala"// infix pattern
  }

  // 6 - Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 - Name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => // name binding => use the name later(here)
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }

  // 8 - Multi-patterns
  val multipattern = aList match {
    case Empty | Cons(0, _) => // compound pattern (multi-pattern)
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  val anything: Any = ???
  anything match {
    case _: RuntimeException | _:NullPointerException => ""
  }

  // ALL.

  /*
    Question.
   */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }

  println(numbersMatch)
  // JVM trick question
}
