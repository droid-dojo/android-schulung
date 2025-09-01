package ninja.droiddojo.samples.functions.extensions


fun main() {

    //Task:     Revisiting the fizz buzz, change the Code to utilize Extension functions to evaluate
    //          if the number is matching a given condition.
    //Sample:   number.isFizzBuzz() -> "FizzBuzz"

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
fun Int.isFizz() : Boolean {
    return this % 3 == 0
}