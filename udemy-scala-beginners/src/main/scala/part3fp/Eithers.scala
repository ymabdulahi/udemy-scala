package part3fp

object Eithers extends App {
    // Idiomatic Error Handling
    // 1. Normal Try and Catch - Not the most efficient
    val magicChar = try {
      // danger
      val scala: String = "Scala"
      scala.charAt(20)
    } catch {
      case e: NullPointerException => 'z'
      case r: RuntimeException => 's'
    } finally {
      // code to clean up resources
      // "does"
    }

    /*
    PROS:
    - it's an expression (unlike Java)
    CONS:
    - cumbersome, hard to read
    - nesting is disgusting
    - finally & side effects
    */

    // 2. RECOVER
    import scala.util.*

    val aTry = Try(2) // Try.apply(2) = Success(2)
    val aFail: Try[Char] = Try {
      // code block
      val scala: String = "Scala"
      scala.charAt(20)
    } // Failure(StringOOBException)

    /*
    PROS over try/catch
    - Care about the value not the exception
    - map, flatMap, filter, for-comprehensions
    - APIs for recovering from exceptions
    - Pattern matching
    */

    val aModifiedTry = aTry.map(_ + 2) // Success(4)
    val aRecoveredFailure = aFail.recover {
      case e: RuntimeException => 'z'
    }

    val aChainedComputation = for {
      x <- aTry
      y <- aRecoveredFailure
    } yield (x, y)

    // 3. ERROR = VALID INFO
    val aRight: Either[String, Int] = Right(22) // "Success"
    val aModifiedRight = aRight.map(_ + 1) // Right(23)
    // map, flatMap, filter
    // for comprehensions

    /*
    PROS OVER Try
    - "Error" can be of any type

    OTHER PROS
    - For Comprehensions
    - APIs for manipulating left/right
    - Pattern matching
    */

    // EITHERS is also a container type
    /*
    Takes two type parameters (one for LEFT and one for RIGHT)
    Popularly used for error handling where LEFT is usually the error case, RIGHT is correct
    Good alternative to using a Try if you would like to return more than just a THROWABLE when there is an error

    def getIntAndAdd1(s: String): Either[String, Int] = {
    try{
      Right(s.toInt)
    } catch {
      case e: Exception => Left("Failed")
      }
    }

    ACCESSING THE CONTENTS OF AN EITHER
    If you want to perform a function on an Either directly, you can first call .isLeft or .isRight
    This finds out which projection of the Either you are dealing with
    Then you can process the Either's value using .left or .right using map

    getIntAndAdd1("12").right.map(map => num + 1) Right(13): scala.util.Either
    getIntAndAdd1("fail").left.map(word => word.toUpperCase) Left(FAILED): scala.util.Either
    getIntAndAdd1("hello").right.map(num => num + 1) Left(Failed): scala.util.Either

    NB: the map will only be performed if the project is correct: E.g. if you call .left.map on a .right, the original right will be returned as the result.

    PATTERN MATCHING EITHERS:
    You can avoid checking for isLeft or isRight by using pattern matching, if a Left is returned do one thing and a Right, do another.

    getIntAndAdd1("12") match { (): Unit
      case Left(_) => println("We have a Left")
      case Right(_) => println("We have a Right")
    }
    prints - We have a Right
    */

    val numOrStr1: Either[Double, String] = Left(2.12)
    val numOrStr2: Either[Double, String] = Right("Scala")

    def info(numOrStr: Either[Double, String]): String =
      numOrStr match {
        case Left(num) => s"number $num"
        case Right(str) => s"string $str"
      }

    info(numOrStr1) // number 2.12
    info(numOrStr2) // string Scala

}
