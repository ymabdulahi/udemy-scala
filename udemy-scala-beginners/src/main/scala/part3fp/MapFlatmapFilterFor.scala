package part3fp

object MapFlatmapFilterFor extends App {

  // go to scala-lang.org for more on this

  val list = List(1,2,3) // standard library list implementation
  println(list.head) // prints 1
  println(list.tail) // prints 2,3

  // MAP
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // FILTER
  println(list.filter(_ % 2 == 0))

  val aFilteredList = List(1,2,3,4,5).filter(_ <= 3) // equivalent to filter.(x => x <= 3)
  // filter takes a function from int to boolean
  // returns for which the predicate produces true - returns 1,2,3

  // FLATMAP
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair)) // List(1, 2, 2, 3, 3, 4)

  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")

  // numbers and chars combo - if you have TWO loops you do a map and flatMap
  val pairUp = numbers.flatMap(n => chars.map(c => "" + c + n)) // List("a1", "a2"... "d4")
  println(pairUp)

  // "iterating" - you do THREE loops - with numbers chars and colors - 3 way loop of two flatmaps and a map at the end
  val combinations = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)

  // MORE EXAMPLES FOR FLATMAP

  val aMappedList: List[Int] = List(1,2,3).map(x => x + 1) // HOF
  val aFlatMappedList = List(1,2,3).flatMap { x =>
    List(x, 2 * x)
    // alternative syntax, same as .flatMap(x => List(x, 2 * x))
    // Console: List(1, 2, 2, 4, 3, 6) - flatMap - gets all the pairs returns and puts it in one big List
  }

  // all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c' - all combos all in a big list
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))

  // foreach - but better to use for comprehensions
  list.foreach(println) // print them on separate lines

  // for comprehensions for the map and flatmap
  val forCombinations1 = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations1)

  // FOR COMPREHENSIONS - following example from above
  val forCombinations2 = for {
    n <- numbers if n % 2 == 0 // if is called a GUARD (filter out things e.g numbers)
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations2)

  for {
    n <- numbers
  } println(n)

  // For Comprehensions - to help with the allPairs example above - can get complicated/hard to read
  // For here is not For Loops - single expression can be reduced to a single value
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatMap chain above
  // more readable


  // syntax overload
  list.map { x =>
    x * 2
  }


}
