import scala.math.BigInt

object Factorial extends App{
  def factorial(i: BigInt, acc: BigInt): BigInt = if (i == 0) acc else factorial(i - 1, i * acc)
  println(factorial(100001, 1))
}