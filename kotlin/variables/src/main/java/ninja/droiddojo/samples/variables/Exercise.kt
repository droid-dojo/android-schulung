package ninja.droiddojo.samples.variables


fun main() {

    val a: Person = Man("Hans Peter", "Germany", 42)

    val age = when (a) {
        is Man -> a.age
        is Woman -> a.age
    }


}

sealed interface Person {
    val name: String
}

//sealed class Person {
//    abstract val name: String
//}

data class Man(
    override val name: String,
    val location: String,
    val age: Int
) : Person

data class Woman(
    override val name: String,
    val location: String,
    val age: Int,
    val favoriteFruits: String
) : Person



