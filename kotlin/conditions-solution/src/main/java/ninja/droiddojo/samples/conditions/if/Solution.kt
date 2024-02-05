package ninja.droiddojo.samples.conditions.`if`


fun main() {
    println("Who are you?")
    val input = readlnOrNull()

    if (input.isNullOrBlank()) {
        println("Invalid Input, please specify your Name")
    } else {
        println("Hello $input")
    }

    //Alternative:
    println(if (input.isNullOrBlank()) "Invalid Input, please specify your Name" else "Hello $input")

}