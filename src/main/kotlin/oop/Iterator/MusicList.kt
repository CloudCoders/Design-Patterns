package oop.Iterator

class MusicList: Iterable<MusicList.Song> {
  override fun getIterator(type: TypeIterator): Iterator<Song> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  data class Song(val title: String,val artist: String)
  val musicList =
    mutableListOf(
      Song("Never too late","Three Days Grace"),
      Song("The Only Exception", "Paramore"),
      Song("Welcome to the Black Parade", "My Chemical Romance"),
      Song("Pieces", "Sum41")

  )

}
