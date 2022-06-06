package part1basics

object ValuesVariablesTypes extends App {
  // this is the syntax for declaring a val
  // val can not be reassigned once they have a value
  // VAL ARE IMMUTABLE - similar to const
  // TYPES of val is optional - compiler can infer the types from the right hand side
  // val x = 42 is the same as val x: Int = 42
  // ; are not necessary in scala - only needed if you right multiple lines - they are written on their own lines

  val x: Int = 42
  println(x)

  val aString: String = "Hello"
  println(aString)
  val anotherString: String = "Goodbye"

  // can only hold true or false
  val aBoolean: Boolean = true

  // can only hold single characters
  val aChar: Char = 'a'

  // consistent with Java syntax
  val anInt: Int = x
  val aShort: Short = 1996
  val aLong: Long = 19962006
  val aFloat: Float = 1.43210f
  val aDouble: Double = 3.14

  // Variables
  // var are mutable - so can be reassigned
  var aVariable: Int = 4

  aVariable = 5
  println(aVariable)
  // side effects - allow us to see what the program are doing
  // functional programming - example like above, changing the variable
}
