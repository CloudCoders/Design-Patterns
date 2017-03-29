package oop.Composite

import oop.Composite.base.ChineseCooker
import oop.Composite.base.ItalianCooker
import oop.Composite.base.Kitchen

fun main(args : Array<String>) {

  val chinese = ChineseCooker()
  val italian = ItalianCooker()
  val cookers = mutableListOf(chinese, italian)
  val kitchen = Kitchen(cookers)
  kitchen.cook()

  kitchen.remove(italian)
  kitchen.add(chinese)
  kitchen.cook()

}
