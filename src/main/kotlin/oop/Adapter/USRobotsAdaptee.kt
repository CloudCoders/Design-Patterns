package oop.Adapter

interface USRobotsAdaptee{
  var speedInMilesPerHour: Double
  fun enableFirstLawMode()
  fun jump(feet: Double)
}

class USRobot(override var speedInMilesPerHour: Double = 0.0) :USRobotsAdaptee{
  override fun enableFirstLawMode() {
    println("Partial first law enabled")
  }

  override fun jump(feet: Double) {
    println("JUMPED $feet feet")

  }

}
