package oop.Iterator

interface Iterable<T> {
  fun getNormalIterator(): Iterator<T>
  fun getBackwardsIterator(): Iterator<T>
}

