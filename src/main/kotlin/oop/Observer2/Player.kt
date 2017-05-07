package oop.Observer2


data class Player (val name: String,
                   var currentCategory: String = "history") : Observer<String> {

  override fun onChange(newValue: String) {
    currentCategory = newValue
    println("New category is $newValue")
  }
}
