package oop.Flyweight

import org.jetbrains.annotations.TestOnly

class SoldierFactory {
  companion object {
    var admiral: Admiral? = null
    var captain: Captain? = null

      fun getSoldier(type: Int): Soldier{
      when(type){
        1 -> {
          if(admiral == null){
            admiral = Admiral()
          }
          return admiral!!
        }
        2 -> {
          if(captain == null){
            captain = Captain()
          }
          return captain!!
        }
      }
      throw IllegalArgumentException()
    }

    @TestOnly
    fun clearInstances(){
      admiral = null
      captain = null
    }
  }


}
