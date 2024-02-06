package ninja.droiddojo.samples.functions.extensions


fun main() {

    //Task:     Revisiting the fizz buzz, change the Code to utilize Extension functions to evaluate
    //          if the number is matching a given condition.
    //Sample:   number.isFizzBuzz() -> "FizzBuzz"

    val threeHanses = "Hans" * 1000

    println(threeHanses)

    repeat(100) { number ->
        println(
            when {
                number % 5 == 0 && number.isFizz()-> "FizzBuzz"
                number.isFizz() -> "Fizz"
                number % 5 == 0 -> "Buzz"
                else -> number.toString()
            }
        )
    }
}

operator fun String.times(other: Int) : String {
    var string = ""

    repeat(other) {
        string = string + this
    }

    return string
}

fun Int.isFizz() : Boolean {
    return this % 3 == 0
}