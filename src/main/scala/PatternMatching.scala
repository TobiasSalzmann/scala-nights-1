object PatternMatching {
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape
  case class Triangle(width: Double, height: Double) extends Shape

  def area(shape: Shape): Double = ???

  def circumference(shape: Shape): Double = ???

  def isSquare(shape: Shape): Double = ???
}
