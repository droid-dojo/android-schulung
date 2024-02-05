package ninja.droiddojo.samples.classes.solution.dataclasses


data class Person(
    val name: String,
    val age: Int
)

fun main() {

    val person1 = Person(name = "Hans Peter", age = 42)
    val person2 = Person(name = "Hans Peter", age = 42)

    println(person1 == person2)

    val person3 = Person(name = "Hans Peter Senior", age = 99)

    println(person1 == person3)

}