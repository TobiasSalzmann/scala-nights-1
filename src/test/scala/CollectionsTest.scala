import org.scalatest.{FlatSpec, Matchers}

class CollectionsTest extends FlatSpec with Matchers{

  "characterOccurences" should "count characters in string" in {
    Collections.characterOccurences("hello") shouldBe Map(
      'h' -> 1,
      'e' -> 1,
      'l' -> 2,
      'o' -> 1
    )
  }
}
