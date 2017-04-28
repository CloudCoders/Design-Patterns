package oop.Template

data class Body(val endpoint: String,
                val parameter: String = "")

sealed class HttpRequest(val body: Body) {
  class Get(body: Body) : HttpRequest(body)
  class Post(body: Body) : HttpRequest(body)
  class Remove(body: Body) : HttpRequest(body)
}
