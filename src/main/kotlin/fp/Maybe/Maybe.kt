package fp.Maybe

sealed abstract class Maybe<T> {
  companion object {
    fun <T> of(value : T) : Just<T> = Just(value)

    fun <T> nothing() : Nothing<T> = Nothing()

    fun <T> fromNullable(value : T?) : Maybe<T> =
      if (value != null) Just(value) else Nothing()
  }

  abstract fun isJust() : Boolean

  abstract fun isNothing() : Boolean

  abstract fun getValue() : T?

  abstract fun map(fn : (T) -> T?) : Maybe<T>

  abstract fun apply(fn : (T) -> Any?) : Maybe<Any?>

  abstract fun getOrElse(other : Any? = null) : Any?

}

class Just<T>(private val value : T) : Maybe<T>() {
  override fun isJust() : Boolean = true

  override fun isNothing() : Boolean = false

  override fun getValue(): T? = value

  override fun map(fn: (T) -> T?): Maybe<T> = fromNullable(fn(value))

  override fun apply(fn: (T) -> Any?): Maybe<Any?> = fromNullable(fn(value))

  override fun getOrElse(other: Any?): Any? = value as Any
}

class Nothing<T> : Maybe<T>() {

  override fun isJust(): Boolean = false

  override fun isNothing(): Boolean = true

  override fun getValue(): T? = null

  override fun map(fn: (T) -> T?): Maybe<T> = this

  override fun apply(fn: (T) -> Any?): Maybe<Any?> = nothing()

  override fun getOrElse(other: Any?): Any? = other

}
