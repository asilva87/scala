import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

trait Being:
  def name: String
  def age: Int

trait Speaker:
  def speak(): Unit

trait Barker:
  def bark(): Unit

trait Meower:
  def meow(): Unit

class Person(val name: String, val age: Int) extends Being with Speaker:
  def speak() = s"Hello! My name is $name and I'm $age ${if age == 1 then "year" else "years"} old."

class Dog(val name: String, val age: Int) extends Being with Barker:
  def bark() = s"Woof! Woof! I! $name! I! $age!! Woof!"

class Cat(val name: String, val age: Int) extends Being with Meower:
  def meow() = s"Meow! My royal name is $name... I'm $age summers young..."

enum PetType:
  case Dog, Cat

def getAge(question: String): Int =
  var age = 0

  while age < 1 do
    println(question)
    age = readInt()

    if age <= 0 then
      println("Invalid age. Value needs to be larger than zero.")

  return age

def cleanString(text: String, capitalize: Boolean = true): String = 
  val cleanedText = text.trim().toLowerCase()

  return if capitalize then cleanedText.capitalize else cleanedText

@main def traitsAndClasses() =
  // Get person's info ====================================
  println("What is your first name?")
  val personName = cleanString(readLine())

  var personAge = getAge("How old are you?")
  val person = Person(personName, personAge)

  // Get pet's info =======================================
  var petType: Option[PetType] = None

  while (petType.isEmpty) do
    println(s"Do you have a ${cleanString(PetType.Dog.toString(), false)} or a ${cleanString(PetType.Cat.toString(), false)}?")
    val input = cleanString(readLine(), false)

    petType = input match
      case "dog" => Some(PetType.Dog)
      case "cat" => Some(PetType.Cat)
      case _ => 
        println("""Invalid pet type! Must be either "dog" or "cat".""")
        None

  println(s"What is your ${petType.map(_.toString).getOrElse("Invalid pet.")}'s name?")
  val petName = cleanString(readLine())

  val petAge = getAge(s"How old is your ${petType.map(_.toString).getOrElse("Invalid pet.")}?")
  val pet = if petType == PetType.Dog then Dog(petName, petAge) else Cat(petName, petAge)

  // Print all information ================================
  println(s"Your name is $personName and you are $personAge ${if personAge == 1 then "year" else "years"} old.")
  println(s"Your ${petType.map(_.toString).getOrElse("Invalid pet.")}'s name is $petName and it is $petAge ${if petAge == 1 then "year" else "years"} old.")