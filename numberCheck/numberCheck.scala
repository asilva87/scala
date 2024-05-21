import scala.io.StdIn.readInt

@main def numberCheck(): Unit =
  println("Input number: ")
  val num = readInt()

  if num < 0 then
    println("The number is negative.")
  else if num > 0 then
    println("The number is positive")
  else
    println("The number is zero.")

  val isEven = num % 2 == 0

  println(s"The number is ${if isEven then "even" else "odd"}.")