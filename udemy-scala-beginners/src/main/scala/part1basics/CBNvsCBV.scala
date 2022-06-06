package part1basics

object CBNvsCBV extends App {

  // values are identical
  // uses the number evaluated in uses it in the parameter of x throughout - hence why its the same
  // the output L can replace the X annd the System.nanoTime() when calling BY VALUE
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // => tells compiler that the parameter will be called BY NAME
  // => explains why the name values are different
  // passed by name every single time, so it is evaluated individually - evaluated 2 different times
  // => delays the evaluation
  // x can be replaced by System.nanonTime()
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(34, infinite())
  
}
