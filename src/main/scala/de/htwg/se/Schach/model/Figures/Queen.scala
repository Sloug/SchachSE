package de.htwg.se.Schach.model.Figures

import de.htwg.se.Schach.util.Colour.Colour
import de.htwg.se.Schach.model.Field.Field
import de.htwg.se.Schach.model._
import de.htwg.se.Schach.model.rules.Moves.queenMove
import de.htwg.se.Schach.util.{Colour, Coordinates}

case class Queen(colour: Colour, stepCounter: Int) extends Figure {

  override def getName: String = "Queen"

  override def getPossibleNewPositions(field: Field, coordinates: Coordinates): Vector[Vector[Coordinates]] = queenMove(field, this.colour, coordinates)

  override def toString: String = if (colour == Colour.black) "♛" else "♕"

  override def move: Figure = {
    Queen(this.colour, this.stepCounter + 1)
  }

  override def unMove: Figure = {
    Queen(this.colour, this.stepCounter - 1)
  }
}

object Queen {

  import Figure.{ROW_BLACK, ROW_WHITE}

  val COL_FIGURE = 3
  val COORDINATES_BLACK: Coordinates = Coordinates(ROW_BLACK, COL_FIGURE)
  val COORDINATES_WHITE: Coordinates = Coordinates(ROW_WHITE, COL_FIGURE)
}