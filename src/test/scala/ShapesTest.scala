import Shapes.{Circle, Rectangle}
import org.scalatest.{FlatSpec, Matchers}

class ShapesTest extends FlatSpec with Matchers {
  "area" should "compute area of circle" in {
    Shapes.area(Circle(2)) shouldBe 12.56 +- 0.1
  }

  "area" should "compute area of rectangle" in {
    Shapes.area(Rectangle(2, 4)) shouldBe 8
  }

  "circumference" should "circumference of rectangle" in {
    Shapes.circumference(Rectangle(2, 4)) shouldBe 12
  }

  "circumference" should "circumference of circle" in {
    Shapes.circumference(Circle(1)) shouldBe 6.28 +- 0.1
  }

  "isSquare" should "be only true for squares" in {
    Shapes.isSquare(Circle(1)) shouldBe false
    Shapes.isSquare(Rectangle(3,6)) shouldBe false
    Shapes.isSquare(Rectangle(3,3)) shouldBe true
  }
}
