package oop.Template

class StringController(val service: StringService) : TemplateController<String, String>(service) {
  override fun findOne(id: String): String? = service.findOne(id)

  override fun findAll(): Collection<String> = service.findAll()

  override fun add(item: String): String = service.add(item)

  override fun remove(id: String): Boolean = service.remove(id)
}
