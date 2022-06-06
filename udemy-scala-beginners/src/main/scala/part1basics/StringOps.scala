package part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // all Java functions available in Scala
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  // replacing chars with something else
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  // Scala own utilities
  val aNumberString = "2"
  // converting string into an integer
  val aNumber = aNumberString.toInt
  // prepending and appending
  println('a' +: aNumberString :+ 'z')
  // reverses the string
  println(str.reverse)
  // take chars out of the string - return He
  println(str.take(2))

  // Scala-specific: String interpolators.

  // S-interpolators
  // s" " > injects age and name variables in the quotes - $ expanded tells it will be injected in the string
  // don't forget the s in the beginning
  // can manipulate the variable - { } can write any expression inside the curly braces
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  println(anotherGreeting)

  // F-interpolators
  // format - f" "
  // % print f like format
  // outputs - "David can eat 1.20 burgers per minute" - formats the 2.2 with enough precision using the % for decimals
  // for fomatted strings, similar to printf
  // compiler can check for type correctness - if the types don't match
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  // will print out everything within raw" " literally
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  // if you do the below - it will print on the new line
  println(raw"$escaped")

}
