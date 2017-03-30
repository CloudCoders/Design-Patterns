package oop.Composite

interface Cooker {
  fun cook()
}

class ChineseCooker(private val cookers: MutableList<Cooker> = mutableListOf()) : Cooker {

  fun add(cooker: Cooker){
    cookers.add(cooker)
  }

  override fun cook() {
    println("Cooking plate")
    cookers.forEach(Cooker::cook)
  }

}

class ItalianCooker(private val cookers: MutableList<Cooker> = mutableListOf()) : Cooker {

  fun add(cooker: Cooker){
    cookers.add(cooker)
  }

  override fun cook() {
    println("Cooking plate with a lot of cheese")
    cookers.forEach(Cooker::cook)
    cookers.removeAll(cookers)
  }
}

class DeepFryer : Cooker {
  override fun cook() {
    println(" with fried food")
  }
}

//to grate the cheese
class Grater : Cooker {
  override fun cook() {
    println(" with grater ")
  }

}

class Kitchen(private val cookers: MutableList<Cooker> = mutableListOf()) : Cooker {
  override fun cook() {
    cookers.forEach(Cooker::cook)
  }

  fun add(cooker: Cooker) = cookers.add(cooker)

  fun remove(cooker: Cooker) {
    cookers.remove(cooker)
  }
}
