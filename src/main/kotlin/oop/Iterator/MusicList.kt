package oop.Iterator

class MusicList: Iterable {
  data class Song(val title: String,val artist: String)
  val musicList =
    mutableListOf(
      Song("Never too late","Three Days Grace"),
      Song("The Only Exception", "Paramore"),
      Song("Welcome to the Black Parade", "My Chemical Romance"),
      Song("Pieces", "Sum41")

  )
  override fun getIterator(): Iterator {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}
