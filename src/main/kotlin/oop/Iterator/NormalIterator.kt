package oop.Iterator

class NormalIterator<T>(val list: MutableList<T>) : Iterator<T> {
  private var index = 0

  override fun first(): T? {
    index = 0
    return get()
  }

  override fun hasNext(): Boolean = this.list.size > index + 1

  override fun hasPrev(): Boolean = index - 1 > -1

  override fun nextIndex(): Int = if (index > this.list.size) index + 1 else -1

  override fun prevIndex(): Int = if (index > -1) index - 1 else -1

  override fun next(): T? = if (hasNext()) list[index++] else throw NoSuchElementException()

  override fun prev(): T? = if (hasPrev()) list[index++] else throw NoSuchElementException()

  override fun set(element: T) {
    list[index] = element
  }

  override fun get() = list[index]

  override fun <B> map(res: (T) -> B): MutableList<B> {
    val res = ArrayList<B>(list.size)
    first()
    while (hasNext()) res.add(res(next()!!))
    res.add(res(get()))
    first()
    return res
  }

  override fun forEach(res: (T) -> Unit) {
    first()
    while (hasNext()) {
      res(next()!!)
    }
    res(get()!!)

  }

  override fun filter(res: (T) -> Boolean): MutableList<T> {
    val res = ArrayList<T>()
    first()

    while (hasNext()) {

      if (res((get()!!))) res.add(next()!!)
      else next()
    }
    return res
  }


}
