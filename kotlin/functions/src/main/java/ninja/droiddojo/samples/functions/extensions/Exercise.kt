package ninja.droiddojo.samples.functions.extensions


fun main() {

    //Task:     Revisiting the fizz buzz, change the Code to utilize Extension functions to evaluate
    //          if the number is matching a given condition.
    //Sample:   number.isFizzBuzz() -> "FizzBuzz"

    repeat(100) { number ->
        println(
            when {
                TODO() -> "FizzBuzz"
                TODO() -> "Fizz"
                TODO() -> "Buzz"
                else -> number.toString()
            }
        )
    }
}