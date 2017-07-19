import org.scalatest.{FlatSpec, Matchers}

class HappinessCheckTest extends FlatSpec with Matchers{
  private val rawCheck1 = "2017-07-19,TIM,0,1,3,7,4"
  private val check1 = HappinessCheck(
    "TIM",
    "2017-07-19",
    Map(1 -> 0, 2 -> 1, 3 -> 3, 4 -> 7, 5 -> 4)
  )

  private val rawCheck2 = "2017-07-20,DON,0,1,7,1,2"
  private val check2 = HappinessCheck(
    "DON",
    "2017-07-20",
    Map(1 -> 0, 2 -> 1, 3 -> 7, 4 -> 1, 5 -> 2)
  )



  "HappinessCheck" should "be parsed from line" in {
    HappinessCheck.parse(rawCheck1) shouldBe check1
  }

  "A list of HappinessCheck" should "be parsed from csv" in {
    HappinessCheck.parseLines(Iterator(rawCheck1, rawCheck2)) shouldBe List(check1, check2)
  }

  "mean" should "compute mean value" in {
    check1.mean shouldBe 3.93 +- 0.01
  }

  "sortedVotes" should "flatten and sort distribution" in {
    check1.sortedVotes shouldBe List(2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5)
  }

  "median" should "compute median for odd number of datapoints" in {
    val check = HappinessCheck("TEAM", "2017-07-20", Map(2 -> 4, 3 -> 1, 4 -> 4))
    check.median shouldBe 3
  }

  "median" should "compute median for even number of datapoints" in {
    val check = HappinessCheck("TEAM", "2017-07-20", Map(2 -> 4, 3 -> 1, 4 -> 1, 5 -> 4))
    check.median shouldBe 3.5
  }

  "variance" should "compute variance" in {
    val check = HappinessCheck("TEAM", "2017-07-20", Map(1 -> 1, 2 -> 2, 3 -> 18, 4 -> 2, 5 -> 1))
    check.variance shouldBe 0.5
  }

  "stdDev" should "compute standard deviation" in {
    val check = HappinessCheck("TEAM", "2017-07-20", Map(1 -> 1, 2 -> 2, 3 -> 18, 4 -> 2, 5 -> 1))
    check.stdDev shouldBe 0.7071 +- 0.001
  }
}
