import scala.io.StdIn.readLine

@main def helloInteractive() = 
  println("Please enter your first name: ")
  val first = readLine()
  println("Now your surname")
  val surname = readLine()

  println(s"Hello, $first $surname!!")