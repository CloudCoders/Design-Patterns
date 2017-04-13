package fp.Maybe

sealed class Maybe<out A> {

  companion object {
    inline fun <reified A : Any> fromNullable(a: A?) : Maybe<A> = if (a != null) Maybe.Just(a) else Maybe.None
    operator fun <A> invoke(a: A): Maybe<A> = Maybe.Just(a)
  }

  abstract val isEmpty : Boolean

  inline fun <B> fold(ifEmpty : () -> B, fn: (A) -> B): B = when (this) {
    is Maybe.None -> ifEmpty()
    is Maybe.Just -> fn(value)
  }

  inline fun <B> map(fn : (A) -> B) : Maybe<B> = fold({ Maybe.None }, { a -> Maybe.Just(fn(a)) })

  inline fun <B> flatMap(fn : (A) -> Maybe<B>): Maybe<B> = fold({ Maybe.None }, { a -> fn(a) })

  data class Just<out A>(val value: A) : Maybe<A>() {
    override val isEmpty: Boolean = false
  }

  object None : Maybe<Nothing>() {
    override val isEmpty: Boolean = true
  }
}


fun <B> Maybe<B>.getOrElse(default: () -> B): B = fold({ default() }, { it })
