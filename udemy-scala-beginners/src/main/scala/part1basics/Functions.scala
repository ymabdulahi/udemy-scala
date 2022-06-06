package part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + "" + b
  }
  println(aFunction("hello", 3))

  // syntax - def, name of the function, in between parenthesis is parameters (has a name + type),
  // call return type of the function (String), = , after = is a single expression
  // can be put into a code block - also expressions

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  // println(aParameterlessFunction) without the () - only works on Scala 2
  // Scala 3 if it has () then call, if doesn't have () then its fine


  // THINKING OF LOOPS IN A FUNCTIONAL WAY
  // RECURSIVE FUNCTION - CALLS ITSELF
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))
  // prints hellohellohello because n is not equal to 1, its 3
  // WHEN YOU NEED LOOPS, USE RECURSION !!!!!!!

  // RETURN TYPES OF FUNCTIONS:
  // first example you can remove the return type of : String
  // HOWEVER, you can NOT do this for RECURSIVE functions, you need to put the return type of function

  // You can use Unit as a return type
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  // Auxiliary functions can be defined within a code block
  // You can use the function defined in the code block, to determine the return type of the big function you implement
  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n-1)
  }

// 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  def aGreetingFunction(name: String, age: Int) = String {
    "Hi, my name is " + name + " and I am " + age + " years old!"

  }
  println(aGreetingFunction("Yonis", 25))

// 2. Factorial function 1 * 2 * 3 * ... * n - clue its recursive function
  def factorial(n: Int ): Int =  {
    if (n <= 0) 1
    else n * factorial(n-1)
  }

  println(factorial(5))

/* 3. A Fibonacci function
f(1) = 1
f(2) = 1
f(n) = f(n - 1) + f(n - 2)
*/

  def fibonaci(n: Int): Int = {
    if (n <= 2) 1
    else fibonaci(n-1) * fibonaci(n-2)
  }

  println(fibonaci(8)) // 21

// 4. Test if a number is prime - factor of 1 and itself - function not loop it - auxiliary function
 def isPrime(n: Int): Boolean = {
   def byPrime(t: Int): Boolean =
   if (t <= 1) true
   else n % t != 0 && byPrime(t-1)

   byPrime(n / 2)
 }

println(isPrime(37))
println(isPrime(2003))
println(isPrime(37 * 17))

}
