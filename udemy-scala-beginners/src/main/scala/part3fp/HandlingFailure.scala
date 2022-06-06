package part3fp

import scala.util.{Success, Try}

object HandlingFailure extends App {
  /*
  Let's Try[T]
  Exceptions are handled inside try-catch blocks:

  try {
  val config: Map[String, String] = loadConfig(path)
  } catch {
  case _: IOException => // handle IOException
  case _: Exception => // handle other Exception
  }

  - multiple / nested try's make the code hard to follow
  - we can't chain multiple operations prone to failure

  A Try is a wrapper for computation that might fail or not
  sealed abstract class Try[+T]
  case class Failure[+T](t: Throwable) extends Try[T] -> wrap failed computations
  case class Success[+T](value: T) extends Try[T] -> wrap succeeded computations
  */

  // Create Success and Failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // Syntax Sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // Utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // IF you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
  // => for-comprehensions
}
