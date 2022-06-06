package part3fp

object AnonFunctions extends App {

  /*
  val doubler = new Function1[Int, Int] {
    override def apply(x: Int) = x * 2
  }

  OR

  val doubler = (x: Int) => x * 2 // ANON
   */

  // ANONYMOUS FUNCTIONS (LAMBDA)
  val doubler: Int => Int = x => x * 2 // same as above - x is allowed to be assumed and match its type - specify correct type before the =

  // MULTIPLE PARAMS IN A LAMBA
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // NO PARAMS
  val justDoSomething = () => 3

  // NB WITH LAMBDAS
  println(justDoSomething) // FUNCTION ITSELF
  println(justDoSomething()) // CALL

  // CURLY BRACES WITH LAMBDAS
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MORE SYNTACTIC SUGAR
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b


  /*
    2.  Rewrite the "special" adder as an anonymous function
   */
  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))

  /*
    TAKEAWAYS
    Instead of passing anonymous FunctionX instances everytime
    - cumbersome (too heavy)
    - still OO

    We used LAMBDAS - (x, y) => x + y

    EXAMPLE:
    (name: String, age: Int) => name + " is " + age + " years old"

    - name: String > param
    - age > name
    - () > mandatory
    - Int > type
    - => > return type
    - name + " is " + age + " years old" > expression

    - FURTHER SUGARS
    val add: (Int, Int) => Int = _ + _
  */

}
