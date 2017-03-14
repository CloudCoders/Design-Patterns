package Factory.base

import Decorator.littlekai.base.Noodles
import Decorator.littlekai.noodles.EggNoodles
import Decorator.littlekai.noodles.UdonNoodles
import Decorator.littlekai.noodles.WheatNoodles

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
