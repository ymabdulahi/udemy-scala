package part3fp

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // HIGHER ORDER FUNCTION (HOF)
  // A HOF is a fancy name for a function that accepts a function as a parameter and/or returns a function as a result
  // To make use of HOFs we could write a new function called calculate to take a function as a parameter and execute the function.

  // map, flatMap, filter in MyList
  // MATHS GIVING ME A HEADACHE

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1)) // PRINTS 11 - goes through it 10x

  // ntb(f,n) = x => f(f(f...(x))) // returns a lambda - so you can use x however many times necessary
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x)) // lambda

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  // curried functions - want to define a helper function
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)  // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
}

/*
TAKEAWAYS:
 1. Functional Programming = working with functions
  - pass functions as parameters
  - return functions as results

=> Higher Order Functions (HOFs)
def nTimesBetter(f: Int => Int, n: Int): Int => Int = ...

Currying = functions with multiple params lists
def curriedFormatter(a: Int, b: Int)(c: String): String
*/
