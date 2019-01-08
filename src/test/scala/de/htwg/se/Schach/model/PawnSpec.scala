package de.htwg.se.Schach.model

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class PawnSpec extends WordSpec with Matchers {
  "A black Pawn" when {
    "new" should {
      val pawn = new Pawn(Colour.black, true)
      val field = new Field()
      val coordinates = Coordinates(1, 4)
      "have a name" in {
        pawn.getName should be("Pawn")
      }
      "have 2 possible new positions" in {
        pawn.getPossibleNewPositions(field, coordinates)(0).size should be(2)
      }
    }
  }
}
