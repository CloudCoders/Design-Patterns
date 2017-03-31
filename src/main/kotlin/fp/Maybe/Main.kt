package fp.Maybe

// I'm using a Main because I think it is more illustrative in this case

fun main(args: Array<String>) {

  // Silly example

  val maybe3 = Maybe(3)
  val maybe33 = Maybe(33)
  val nullIfLowerThan10: (Int) -> Maybe<Int> = { if (it < 10) Maybe.None else Maybe.Just(it) }
  val returnExplanatoryString: () -> String = { "Result is null" }

  val result3 = maybe3.flatMap(nullIfLowerThan10).getOrElse(returnExplanatoryString)
  val result33 = maybe33.flatMap(nullIfLowerThan10).getOrElse(returnExplanatoryString)

  println(result3)
  println(result33)

  // Better example

  val listOfCountries = listOf("Spain", "France", "England", "Italy")

  val getValueInList: (String) -> (List<String>) -> String? = { item ->
    {
      list -> list.find { it == item }
    }

  }
  val getTanzaniaInList = getValueInList("Tanzania")

  val maybeTanzania = Maybe.fromNullable(getTanzaniaInList(listOfCountries))

  val country = maybeTanzania
    .map(String::toUpperCase)
    .getOrElse(returnExplanatoryString)                                          // Totally safe thanks to Maybe monad

  val countryClassic = listOfCountries.find { it == "Tanzania" }?.toUpperCase()  // Safer thanks to Kotlin nullables


  println(country)            // This won't be null
  println(countryClassic)     // This can be null

  // Which one do you think is better?
}
