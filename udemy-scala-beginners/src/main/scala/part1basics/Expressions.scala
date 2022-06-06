package part1basics

object Expressions extends App {

  // right side is the EXPRESSION
  val x = 1 + 2
  println(x)

  // basic expressions are MATHEMATICAL - maintains the order learnt in school
  // + - * / & | << >> >>> (right shift with zero extension)
  println(2 + 3 * 4)

  println(1 == x)
  // test for equality - so seen as a boolean
  // == != > >= < =<

  println(!(1 == x))
  // logical negation - ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... side effects
  println(aVariable)

  // INSTRUCTIONS (TO DO) v EXPRESSIONS (VALUE)
  // Instructions are executed (Java) v Expressions are evaluated (Scala) (GIVE THE VALUE OF SOMETHING)
  //

  // IF Expressions - returns the expression - not telling it what to do
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)

  // WE DON'T USE LOOPS IN SCALA - DISCOURAGED - specific to imperative programming - like instructions
  // EVERYTHING IN SCALA IS AN EXPRESSION
  // A SIDE EFFECT IN SCALA IS AN EXPRESSION RETURNING A UNIT === VOID - CAN ONLY HOLD ()
  // SIDE EFFECTS: println(), whiles, reassigning

  var b = 0
  val aWhile = while (b < 10) {
    println(b)
    b += 1
  }

  val aWeirdValue = (aVariable = 3) // aWeirdValue = Unit === Void
  println(aWeirdValue) // returns ()

  // CODE BLOCKS
  // define val, write expressions
  // the code block is an expression
  // the value of the block is the value of the last expression
  // compiler says its a string because of the last expression
  // everything declared inside the code block stays VISIBLE within - own definition of values
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // EXERCISES ROCK THE JVM
  // 1. Difference between "hello world" vs println("hello world")
  // value of type string type literal v expression - side effect - prints it to the console

  // 2. boolean - true
  val someValue = {
    2 < 3
  }
  println(someValue)

  // 3. int - 42 // trick question - expression irrelevant - cos the code block is the expression of the last line
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)

}
