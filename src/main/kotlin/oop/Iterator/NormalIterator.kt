package oop.Iterator

class NormalIterator<T>(val list: MutableList<T>): Iterator<T> {
  private var index = 0

  override fun first(): T?{
    index = 0
    return get()
  }

  override fun hasNext(): Boolean = this.list.size > index + 1

  override fun hasPrev(): Boolean = index - 1 > -1

  override fun nextIndex(): Int = if (index > this.list.size) index + 1 else -1

  override fun prevIndex(): Int = if (index > -1) index - 1  else -1

  override fun next(): T? = if (hasNext()) list[index++] else null

  override fun prev(): T? = if (hasPrev()) list[index++] else null

  override fun set(element: T){
    list[index] = element
  }

  override fun get() = list[index]

  override fun <B> map(res: (T) -> B): MutableList<B> {
    val res = ArrayList<B>(list.size)
    first()
    while(hasNext()){
      res.add(res(next()!!))
    }
    return res
  }

  override fun <B> forEach(res: (T) -> B) {
    first()
    while (hasNext()){
      res(next()!!)
    }
  }

  override fun filter(res: (T) -> Boolean): MutableList<T> {
    val res = ArrayList<T>()
    first()
    while (hasNext()){
      if(res((get()!!))) res.add(next()!!)
    }
    return res
  }


}
