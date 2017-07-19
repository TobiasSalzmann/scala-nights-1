import org.scalatest.{FlatSpec, Matchers}

import Functions._

class FunctionsTest extends FlatSpec with Matchers{
  "factorial" should "compute factorial" in {
    factorial(0) shouldBe 1
    factorial(1) shouldBe 1
    factorial(2) shouldBe 2
    factorial(3) shouldBe 6
    factorial(4) shouldBe 24
  }

  "factorialBigInt" should "compute large factorials" in {
    factorialBigInt(0) shouldBe 1
    factorialBigInt(1) shouldBe 1
    factorialBigInt(2) shouldBe 2
    factorialBigInt(3) shouldBe 6
    factorialBigInt(4) shouldBe 24

    factorialBigInt(100) shouldBe BigInt("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000")
    factorialBigInt(100000).bitLength shouldBe 1516705
  }

  "fibonacci" should "compute elements of the fibonacci sequence" in {
    fibonacci(0) shouldBe 0
    fibonacci(1) shouldBe 1
    fibonacci(2) shouldBe 1
    fibonacci(3) shouldBe 2
    fibonacci(4) shouldBe 5

    fibonacci(0, fib0 = 4) shouldBe 4
    fibonacci(1, fib1 = 5) shouldBe 5
    fibonacci(2, 4, 5) shouldBe 9
    fibonacci(2, 4, 5) shouldBe 14
  }

  "applyTwice" should "apply function twice" in {
    val square: Int => Int = n => n * n
    def cube(n : Int) =  n * n * n

    val g = applyBoth(square, cube)

    g(2) shouldBe (4, 8)
    g(3) shouldBe (9, 27)
  }


}
