package fp.Maybe

// I'm using a Main because I think it is more illustrative in this case

fun main(args : Array<String>) {

  // Silly example

  val maybe3 = Maybe.of(3)
  val maybe33 = Maybe.of(33)
  val nullIfLowerThan10 : (Int) -> Int? = { if (it < 10) null else it }

  val result3 = maybe3.map(nullIfLowerThan10).getOrElse("Result is null")
  val result33 = maybe33.map(nullIfLowerThan10).getOrElse("Result is null")

  println(result3)
  println(result33)

  // Better example

  val listOfCountries = listOf("Spain", "France", "England", "Italy")
  val maybeCountry = Maybe.of(listOfCountries)

  val country = maybeCountry
    .apply { it.find { it == "Tanzania" } }
    .map { (it as String).toUpperCase() }
    .getOrElse("That country is not in List")                                     // Totally safe thanks to Maybe monad

  val countryClassic = listOfCountries.find { it == "Tanzania" }?.toUpperCase()   // Safer thanks to Kotlin nullables


  println(country)            // This won't be null
  println(countryClassic)     // This can be null

  // Which one do you think is better?
}
