package oop.Observer2


data class Player (val name: String,
                   var currentCategory: String = "history"){
  fun notify(newCategory: String){
    println("$name: category changed to $newCategory")
  }
}
