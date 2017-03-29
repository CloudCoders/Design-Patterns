package oop.Factory

import oop.Decorator.base.Noodles
import oop.Decorator.noodles.EggNoodles
import oop.Decorator.noodles.UdonNoodles
import oop.Decorator.noodles.WheatNoodles

class NoodlesFactory {

  fun getNoodles(noodleType : Int) : Noodles {
    when (noodleType) {
      1 -> return EggNoodles()
      2 -> return UdonNoodles()
      3 -> return WheatNoodles()
      else -> throw NoNoodlesMatchException("Type is not among defined Noodles")
    }
  }

}
