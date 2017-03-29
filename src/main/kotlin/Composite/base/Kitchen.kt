package Composite.base

class Kitchen(private var cookers: MutableList<Cooker> = mutableListOf()) : Cooker {
  override fun cook() {
    cookers.forEach {it.cook()}
  }

  fun add(cooker: Cooker) = cookers.add(cooker)

  fun remove(cooker: Cooker) {
    cookers = cookers.filterNot { it == cooker } as MutableList<Cooker>
  }
}
