package part3fp

object WhatsAFunction extends App {

  // Use functions as first class elements
  // We want to work with functions like we do with plain values
  // BUT - main issue is that we come from OOP world

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2)) // can call doubler like it was a function - 4 to the console

  // FUNCTION TYPES = Function1 Function[A, B] ... Function22 - up to 22 params
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3" + 4)) // 7 in console

  // FUNCTION TYPES = Function2[A, B, R] === (A, B) => R
  // THIS IS A SYNTACTIC SUGAR
  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // ALL SCALA FUNCTIONS ARE OBJECTS (INSTANCES OF CLASSES)

  /*
    1.  a function which takes 2 strings and concatenates them
   */

  val concatenator: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concatenator("Hi", " my name is Yonis"))

  /*
    2.  transform the MyPredicate and MyTransformer into function types

    trait MyPredicate[-T] { // T => Boolean
    def test(elem: T): Boolean
    }

    trait MyTransformer[-A, B] { // A => B
    def transform(elem: A): B
    }

    // HIGHER ORDER FUNCTIONS RIGHT HERE - receives functions as params or returns a function as a result
    def map[B](transformer: A => B): MyList[B]
    def flatMap[B](transformer: A => MyList[B]): MyList[B]
    def filter(predicate: A => Boolean): MyList[A]

   */


  /*
    3.  define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
        // Function1[Int, Function1[Int, Int]
   */

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function - property that they can be called with multiple param lists
  // superAdder can be called with multiple lists to get to the final result
}

  trait MyFunction[A, B] {
  def apply(element: A): B
  }

/*
TAKEAWAYS:
1. We want to work with FUNCTIONS:
- pass functions as parameters
- use functions as values

2. Problem: Scala works on top of the JVM
- designed for Java
- first-class elements: objects(instances of classes)

3. Solution: ALL Scala functions are objects!
- function traits, up to 22 params
- syntactic sugar

trait Function1[-A, +B] {
def apply(element: A): B
}

SS - Function2[Int, String, Int] === (Int, String) => Int
*/