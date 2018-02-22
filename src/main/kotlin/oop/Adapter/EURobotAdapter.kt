package oop.Adapter

interface EuropeanRobotTarget
{
  var speedInKilometersPerHour: Double
  fun jump(meters: Double)
}

data class EURobotAdapter(var usRobot: USRobot) : EuropeanRobotTarget{
  override var speedInKilometersPerHour: Double
    get() = usRobot.speedInMilesPerHour * 1.6093
    set(value) {usRobot.speedInMilesPerHour = value * 0.62137}



  override fun jump(meters: Double) {
    usRobot.jump(meters * 0.3048)
  }

}
