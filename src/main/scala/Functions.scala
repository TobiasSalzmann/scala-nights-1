import scala.annotation.tailrec

object Functions {

  def factorial(n: Int): Int = ???

  def factorialBigInt(n: BigInt): BigInt = ???

  //Bonus exercise: uncomment the annotation and implement it using tail recursion
  //@tailrec
  def fibonacci(n : Int, fib0: BigInt = 0, fib1: BigInt = 1): BigInt = ???

  def applyBoth(f : Int => Int, g: Int => Int) : Int => (Int, Int) = ???


}
