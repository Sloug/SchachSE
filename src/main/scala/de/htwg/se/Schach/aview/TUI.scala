package de.htwg.se.Schach.aview

import java.awt.Frame

import de.htwg.se.Schach.controller.{CellChanged, Controller, GameStatus}
import de.htwg.se.Schach.util.Observer
import javax.swing.JOptionPane

import scala.swing.Reactor

class TUI(controller: Controller) extends Reactor {
  listenTo(controller)

  def processInputLine(input: String): Unit = {
    val pattern = {
      "[" + controller.getChangableFigures + "]"
    }.r
    input match {
      case "q" =>
      case "n" => controller.newField()
      case "z" => controller.undo
      case "y" => controller.redo
      case _ => input.toList.filter(c => c != ' ').filter(_.isDigit).map(c => c.toString.toInt) match {
        case row :: column :: newRow :: newColumn :: Nil => controller.move(row, column, newRow, newColumn)
        case _ => {
          pattern.findFirstIn(input) match {
            case Some(c) => controller.choose(c)
            case _ => println("Wrong input!")
          }
        }
      }
    }
  }

  reactions += {
    case event: CellChanged => printTui
  }

  def printTui: Unit = {
    println(GameStatus.message(controller.gameStatus))
    println(controller.fieldToString);
  }
}