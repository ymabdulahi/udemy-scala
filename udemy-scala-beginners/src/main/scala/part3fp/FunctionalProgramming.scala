package part3fp

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results
    Conclusion: FunctionX = Function1, Function2, ... Function22 - MAX Args
   */

  // First Int is the arg, Second Int is the return type
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // function with 2 arguments and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", " Scala") // "I love Scala"

  // SYNTAX SUGAR - SHORTHAND VERSION OF WRITING OUT FUNCTIONS - equivalent below
  val doubler: Int => Int = (x: Int) => 2 * x
  doubler(4) // 8

  /*
    same as above
    val doubler: Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(x: Int) = 2 * x
    }
   */

  // HIGHER ORDER FUNCTIONS - take functions as args/functions as results
  // A HOF is a fancy name for a function that accepts a function as a parameter
  // and/or returns a function as a result

  val aMappedList: List[Int] = List(1,2,3).map(x => x + 1) // HOF
  val aFlatMappedList = List(1,2,3).flatMap { x =>
    List(x, 2 * x)
    // alternative syntax, same as .flatMap(x => List(x, 2 * x))
    // Console: List(1, 2, 2, 4, 3, 6) - flatMap - gets all the pairs returns and puts it in one big List
  }

  val aFilteredList = List(1,2,3,4,5).filter(_ <= 3) // equivalent to filter.(x => x <= 3)
  // filter takes a function from int to boolean
  // returns for which the predicate produces true - returns 1,2,3

  // all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c' - all combos all in a big list
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))

  // For Comprehensions - to help with the allPairs example above - can get complicated/hard to read
  // For here is not For Loops - single expression can be reduced to a single value
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatMap chain above

  /*
   * Collections - these are fundamental to functional programming
   */

  // Lists
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // Sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence(1) // the element at index 1: 2

  // Vectors: fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  // Sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 // Set(1,2,4)

  // Ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // List(2,4,6,8..., 2000)

  // Tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // Maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 6437812),
    "Jane" -> 327285 // ("Jane", 327285)
  )
}

