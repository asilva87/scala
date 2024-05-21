import scala.io.StdIn.readInt

@main def listLoop(): Unit = 
  println("Numbers list generator")
  
  var max = 0
  while
    max <= 0
  do
    println("Input the maximum value of your list: ")
    max = readInt()

    if max <= 0 then
      println("Max length should be a positive number")

  var method = -1
  while 
    !Set(0, 1, 2).contains(method)
  do
    println("All numbers(0), only evens(1), or only odds(2)?")
    method = readInt()

    if !Set(0, 1, 2).contains(method) then
      println("Invalid option.")

  // 0 to max produces a Range, which is not a List.
  // Therefore it needs to be converted to List.
  val list = (0 to max).toList
  var filteredList: List[Int] = List()

  if method == 0 then
    filteredList = list
  else if method == 1 then
    filteredList = list.filter(_ % 2 == 0)
  else
    filteredList = list.filter(_ % 2 != 0)
  
  for num <- filteredList do print(s"$num ")