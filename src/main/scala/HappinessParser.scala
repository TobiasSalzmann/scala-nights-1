case class HappinessCheck(teamName: String, date: String, distribution: Map[Int, Int]){
  def +(other: HappinessCheck): HappinessCheck = ???

  val sortedVotes: IndexedSeq[Int] = ???

  val mean: Double = ???

  val median: Double = ???

  val variance: Double = ???
  val stdDev: Double = ???
}

object HappinessCheck {
  type Line = String

  def parseLines(input: TraversableOnce[Line]): List[HappinessCheck] = ???

  def parse(line: Line): HappinessCheck = ???

}



object HappinessCheckApp extends App {
  val rawData = scala.io.Source.fromFile("src/main/resources/happiness.csv").getLines()

  val checks = HappinessCheck.parseLines(rawData)

  val total = checks.reduce(_ + _)

  println(total)
  println(total.mean)
  println(total.median)
  println(total.variance)
  println(total.stdDev)
}
