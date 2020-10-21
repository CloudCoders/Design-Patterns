package oop.Template

interface Service<T, U> {
  fun findOne(id: U): T?
  fun findAll() : Collection<T>
  fun add(item: T): T
  fun remove(id: U): Boolean
}
