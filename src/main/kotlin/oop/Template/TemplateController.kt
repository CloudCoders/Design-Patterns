package oop.Template

abstract class TemplateController<T, E>(private val service: Service<T, E>) {

  abstract fun findOne(id: E) : T?
  abstract fun findAll() : Collection<T>
  abstract fun add(item: T) : T
  abstract fun remove(id: E) : Boolean

  fun handleRequest(request: HttpRequest) : String {
    when (request) {

      is HttpRequest.Get -> {
        return handleGetRequest(request.body)
      }

      is HttpRequest.Post -> {
        return handlePostRequest(request.body)
      }

      is HttpRequest.Remove -> {
        return handleRemoveRequest(request.body)
      }

    }
  }

  private fun handleGetRequest(body: Body) : String =
    when (body.endpoint) {
      "findOne" -> findOne(body.parameter as E).toString()
      "findAll" -> findAll().toString()
      else -> "Error 404: Not Found"
    }

  private fun handlePostRequest(body: Body) : String =
    if (body.endpoint == "add") add(body.parameter as T).toString()
    else "Error 404: Not Found"

  private fun handleRemoveRequest(body: Body) : String =
    if (body.endpoint == "remove") remove(body.parameter as E).toString()
    else "Error 404: Not Found"

}
