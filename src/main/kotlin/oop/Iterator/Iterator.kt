package oop.Iterator

interface Iterator<T> {
  fun first(): T?
  fun next(): T?
  fun prev(): T?
  fun hasNext():Boolean
  fun hasPrev(): Boolean
  fun nextIndex(): Int
  fun prevIndex(): Int
  fun set(element: T)
  fun get() : T
  fun <B> map(res: (T) -> B): MutableList<B>
  fun forEach(res: (T) -> Unit)
  fun filter(res: (T) -> Boolean): MutableList<T>
}
