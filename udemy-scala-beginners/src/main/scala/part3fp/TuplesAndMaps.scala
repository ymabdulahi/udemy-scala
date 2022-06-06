package part3fp

object TuplesAndMaps extends App {
  // Tuples = finite ordered "lists"
  // Is a collection of elements - immutable - heterogeneous
  // Type of tuple is defined by, the number of the element it contains and the datatype of those elements
  // val aTuple = new Tuple2(2, "hello", "Scala")
  val aTuple = (2, "hello, Scala")  // Tuple2[Int, String] = (Int, String)

  println(aTuple._1)  // 2 access the second element
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)  // ("hello, Scala", 2)

  // Maps - keys (index) -> values (data corresponding)
  // Collection of key values pairs - can have any data type - mutable and immutable (default)
  val aMap: Map[String, Int] = Map() // instantiated a map

  // can use either syntax
  val phonebook = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1)
  // a -> b is sugar for (a, b)
  println(phonebook)
  // use withDefaultValue() when the key does not return a value to avoid it crashing

  // Map Ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary"))

  // Add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // Functionals on Maps
  // map, flatMap, filter
  //  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys > used to find all the pairs where the keys satisfies the given predicate
  //  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)
  // mapValues
  println(phonebook.view.mapValues(number => "0245-" + number).toMap)

  // Conversions to other collections
  println(phonebook.toList)
  //  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0))) // prints them in groups based on the first index and puts in a list
  println(names.groupBy(name => name.charAt(0) == 'J'))

  /*
  TAKEAWAYS:
  TUPLES:
  val tuple = (25, "Yonis")
  tuple._1                      // 25 RETRIVE ELEMENTS USING _n
  tuple.copy(_1 = 26)           // (26, Yonis) CREATE NEW TUPLES
  tuple.toString                // "(25, Yonis)" PRETTY PRINT
  tuple.swap                    // (Yonis, 25) SWAP ELEMENTS

  MAPS:
  val phonebook = Map("Yonis -> 25, "Mohamed" -> 55)
  phonebook.contains("Yonis")
  val anotherbook = phonebook + ("Liban", 27)

  FUNCTIONALS
  filterKeys, mapValues
  map, filter, flatMap (on pairings)
  */
}
