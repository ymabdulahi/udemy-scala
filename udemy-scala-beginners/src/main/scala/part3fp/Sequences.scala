package part3fp

import scala.util.Random

object Sequences extends App {

  // Immutable Collection
  // Seq >> IndexedSeq and LinearSeq – can be traversed in a set order
  // IndexedSeq – Vector, String, Range – key property is that it can be accessed quickly in constant time
  // LinearSeq – List, Stream, Stack, Queue – guarantee the ordering of elements

  // Seq
  /*
  trait Seq[A+] {
    def head: A
    def tail: Seq[A]
  }
  A (very) general interface for data structures that
  - have a well defined order
  - can be indexed
  Supports various operations:
  - apply, iterator, length, reverse for indexing and iterating
  - concatenation, appending, prepending
  - a lot of others: grouping, sorting, zipping, searching, slicing
  */
  val aSequence = Seq(1,2,3,4)
  println(aSequence) // prints List(1,3,2,4)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7,5,6)) // ++ is concatenation
  println(aSequence.sorted) // works is the type by default is ordered

  // Ranges - also Seq (more advanced) to and until operators
  val aRange: Seq[Int] = 1 until 10 // 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  // Lists
  /*
  signature of a list:
  sealed abstract class List[A+]
  case object Nil extends List[Nothing]
  case class ::[A](val hd: A, val tl: List[A]) extends List[A]

  A LinearSeq IMMUTABLE linked List
  - head, tail, isEmpty methods are fast: 0(1)
  - most operations are 0(n): length, reverse

  Sealed has TWO subtypes:
  - object Nil (empty)
  - class ::
  */
  val aList = List(1,2,3)
  // val prepended = 42 :: aList prints 42, 1, 2, 3
  val prepended = 42 +: aList :+ 89 // done on both sides
  println(prepended)

  val apples5 = List.fill(5)("apple") // fills out the list - List[apple, apple, apple, apple, apple]
  println(apples5)
  println(aList.mkString("-|-")) // put the | in between


  // Arrays
  /*
  final class Array[T]
  extends java.io.Serializable
  with java.lang.Cloneable

  The equivalent of simple Java arrays
  - can be manually constructed with predefined lengths
  - can be mutated (updated in place)
  - are interoperable with Java's T[] arrays
  - indexing is fast
  - Where's the Seq?!
  */
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3) // will print a default value of 0 - String value will be null
  threeElements.foreach(println)

  // Mutation
  numbers(2) = 0  // syntax sugar for numbers.update(2, 0) - update similar to apply
  println(numbers.mkString(" ")) // prints 1 2 0 4 - 0 replaces 3

  // Arrays and Seq
  val numbersSeq: Seq[Int] = numbers  // implicit conversion
  println(numbersSeq)
  // prints WrappedArray[1,2,0,4] - special kind of sequence


  // Vectors
  /*
  final class Vector[A+]
  The default implementation for immutable sequences:
  - Are immutable data structures providing random access for elements and is similar to the list
  - Effectively constant indexed read and write: 0(log32(n))
  - fast element addition: append/prepend
  - implemented as a fixed-branched trie (branch factor 32)
  - good performance for large sizes

  val noElements = Vector.empty
  val numbers = noElements :+ 1 :+ 2 :+ 3  // Vector(1,2,3)
  val modified = numbers updated (0, 7) // Vector (7,2,3)

  */
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // Vectors vs Lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random // Random is random generator
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime() // beginning
      collection.updated(r.nextInt(maxCapacity), r.nextInt()) // operation - a collection of all the measurements in this function - update at a random index
      System.nanoTime() - currentTime // when done in the end
    }

    times.sum * 1.0 / maxRuns // average time for the collection to be updated and return
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // Advantages of a List:
  // keeps reference to tail
  // Disadvantage of a List:
  // updating an element in the middle takes long
  println(getWriteTime(numbersList))
  // 8924061.971 avg time

  // Advantages of a Vector:
  // depth of the tree is small
  // Disadvantage of a Vector
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))
  // 4361.081 avg time 
}
