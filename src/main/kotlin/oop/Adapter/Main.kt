package oop.Adapter

fun main(args: Array<String>) {

  val euRobot = EURobotAdapter(USRobot())
  euRobot.speedInKilometersPerHour = 3.4

  println("Current speed in KM/h: ${euRobot.speedInKilometersPerHour}")
  euRobot.jump(12.5)

}
