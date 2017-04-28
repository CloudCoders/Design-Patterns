package oop.Template

class StringService : Service<String, String> {

  private val fakeList = mutableListOf(
    Pair("1", "Test 1"),
    Pair("2", "Test 2"),
    Pair("3", "Test 3")
  )

  override fun findOne(id: String): String? =
    fakeList.firstOrNull { it.first == id }?.second

  override fun findAll(): Collection<String> =
    fakeList.map { it.second }

  override fun add(item: String): String {
    val lastId = fakeList.last().first.toInt() + 1
    fakeList.add(Pair(lastId.toString(), item))
    return item
  }

  override fun remove(id: String): Boolean =
    fakeList.remove(fakeList.find { it.first == id })
}
