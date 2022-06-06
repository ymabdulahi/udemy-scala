package part3fp

import scala.util.Random

object Options extends App {
  // Option is referred to a carrier of single or no element for a stated type.
  // When a method returns a value which can even be null then Option is utilized
  // i.e., the method defined returns an instance of an Option, in place of returning a single object or a null

  /*
  IMPORTANT POINTS
  - The instance of an Option that is returned here can be an instance of Some class or None class in Scala
    where Some and None are the children of Option class.
  - When the value of a given key is obtained then Some class is generated.
  - When the value of a given key is not obtained then None class is generated.
  */

  /*
  ROCKTHEJVM
  OPTION > is a wrapper for a value that might be present or not
  See it as the possible absence of a value
  Avoid using null pointers

  sealed abstract class Option[A+]
  case class Some[A+](x: A) extends Option[A] ---> Some wraps a concrete value
  case object None extends Options[Nothing] ---> None is a singleton for absent values

  Options are present in many places:
  val map = Map("key" -> "value")
  map.get("key")    // Some(value)
  map.get("other")  // None
  Map uses options on its basic get operation; prefer it over apply

  val numbers = List(1, 2, 3)
  list.headOption         // Some(1)
  list.find(_ % 2 == 0)   // Some(2)
  Lots of functions on all collections work with options
  */

  // Initialising
  val myFirstOption: Option[Int] = Some(4)
  val noOptions: Option[Int] = None

  // Options created to deal with Unsafe APIs - this is how you work with APIs
  def unsafeMethod(): String = null
  // val result = Some(null) // WRONG - Some needs to return a value
  val result = Option(unsafeMethod()) // SOME OR NONE
  println(result)

  // Chained Methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  // allows for better calling of Options
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // Functions on Options
   println(myFirstOption.isEmpty) // return false
   println(myFirstOption.get) // unsafe - behaves like a null pointer

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))


  /* EXERCISE */
  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // Try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")
  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)
    return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  /*
    if (c != null)
      return c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect)
  // if (connectionStatus == null) println(None) else print (Some(connectionstatus.get))
  println(connectionStatus)
  /*
    if (status != null)
      println(status)
   */
  connectionStatus.foreach(println)

  // Chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // For-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  forConnectionStatus.foreach(println)

  /*
  YT: ProgrammingKnowledge on Scala Options Type
  // Scala - Options (Some or None)

    object Demo {
      val lst = List(1, 2, 3);
      val map = Map(1 -> "Tom", 2 -> "Max", 3 -> "John");
      val opt : Option[Int] = Some(5); // None; -- either is valid
      def main(args: Array[String]) {
        println(lst.find(_ > 2).get); print Some(2) -- .get will give the value in the console
        println(map.get(1).getOrElse("No Name Found")); print Some(Max) -- getOrElse to avoid Exception error
      }
    }



  */
}
