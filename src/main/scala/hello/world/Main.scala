package hello.world

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportTopLevel, JSImport}
import scala.scalajs.LinkingInfo

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import org.scalajs.dom.document

@JSImport("resources/index.css", JSImport.Default)
@js.native
object IndexCSS extends js.Object

object Main {
  val css = IndexCSS

  @JSExportTopLevel("main")
  def main(): Unit = {
    val NoArgs =
      ScalaComponent
        .builder[Unit]
        .renderStatic(<.div("Hello watodsifj world!"))
        .build

    NoArgs().renderIntoDOM(document.body)
  }
}
