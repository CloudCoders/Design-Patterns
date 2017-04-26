package oop.Iterator

interface Iterable<T> {
  fun getIterator(type: TypeIterator): Iterator<T>
}

