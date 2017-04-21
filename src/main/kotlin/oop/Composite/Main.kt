package oop.Composite


fun main(args : Array<String>) {

  val chinese = ChineseCooker()
  chinese.add(DeepFryer())

  val italian = ItalianCooker()
  italian.add(Grater())

  val italianWithOil = ItalianCooker()
  italianWithOil.add(DeepFryer())
  italianWithOil.add(Grater())

  val cookers = mutableListOf(chinese, italian)
  val kitchen = Kitchen(cookers)
  kitchen.cook()

  kitchen.remove(italian)
  kitchen.add(chinese)
  kitchen.add(italianWithOil)
  kitchen.cook()

}
