package oop.Iterator

class BackwardsIterator<T>(list: MutableList<T>): NormalIterator<T>(list) {
  override fun first(): T? {
    index = list.size - 1
    return get()
  }

  override fun hasNext(): Boolean = index - 1 > -1

  override fun hasPrev(): Boolean = this.list.size > index + 1

  override fun nextIndex(): Int = if(index > -1) index - 1 else -1

  override fun prevIndex(): Int = if(index > this.list.size) index +1 else -1

  override fun next(): T? = if (hasNext()) list[index--] else throw NoSuchElementException()

  override fun prev(): T? = if (hasPrev()) list[index++] else throw NoSuchElementException()
}
