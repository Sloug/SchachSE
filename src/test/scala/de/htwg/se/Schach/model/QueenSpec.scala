package de.htwg.se.Schach.model

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class QueenSpec extends WordSpec with Matchers {
  "A black Queen" when {
    "new" should {
      val queen = new Queen(Colour.Black)
      "have a name" in {
        queen.getName should be("Queen")
      }
      "have 21 possible new positions" in {
        queen.getPossibleNewPositions.size should be(21)
      }
      "have an ability" in {
        queen.hasAbility should be(false)
      }
    }
  }
}