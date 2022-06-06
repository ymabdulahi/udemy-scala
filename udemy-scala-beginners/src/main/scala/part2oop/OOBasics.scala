package part2oop

object OOBasics extends App {

  // instantiate the class
  val person = new Person("Yonis", 25)
  println(person.age)
  person.greet("Mohamed")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10000).print
}

// class organises the data and behaviours
// pass parameters through - below is a CONSTRUCTOR - all instance of person
// must contain the parameters for it to be constructed correctly

// class parameters are NOT FIELDS - so need to add val/var keyword
// if you want to print it to the console - person.age

  class Person (name: String, val age: Int) {
    // body for the class
    // contain, methods, functions, definitions
    // same as a block expression
    // evaluates everything in the block - giving side effects too

    val x = 2

    println(1 + 3)

    // method
    // this keyword - to access a certain instance - so this.name refers to Yonis
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

    // overLOADING - defining methods with the same name, but different signatures
    // different signatures - diff num of parameters or different types or even return types
    def greet(): Unit = println(s"Hi, I am $name")

    // multiple constructors
    // auxiliary constructor - calls the primary constructor with this keyword
    // below is done, so to omit the number
    def this(name: String) = this(name, 0)

    // in the person class can add 0 > val age: Int = 0 to give
    def this() = this("John Doe")
}

/*
  Novel and a Writer

  Writer: first name, surname, year
  - method full name

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy (author)
  - copy (new year of release) = new instance of Novel
*/

 class Writer (firstName: String, surname: String, val year: Int) {
   def fullName: String = firstName + "" + surname
 }

class Novel (name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int)= new Novel(name, newYear, author)
}

/*
  Counter class
  - receives an int value
  - method current count
  - method to increment/decrement => return new Counter
  - overload inc/dec to receive an amount
*/

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)  // immutability - important to functional programming
    // instances are fixed and can't be modified
    // whenever you need to modify the content of an instances
    // you need to return a new instance for it
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n-1)

  def print = println(count)
}

