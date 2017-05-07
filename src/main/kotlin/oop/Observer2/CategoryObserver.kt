package oop.Observer2

class CategoryObserver : Observer<String> {
  override val list = mutableListOf<Player>()

  override fun onChange(newValue: String){
    list.forEachIndexed { _, player ->
      player.notify(newValue)
    }
  }
}
