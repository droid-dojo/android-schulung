package ninja.droiddojo.samples.conditions.`when`


fun main() {
    repeat(100) { number ->
        println(
            when {
                number == 0 -> "0"
                number % 3 == 0 && number % 5 == 0 -> "FizzBuzz"
                number % 3 == 0 -> "Fizz"
                number % 5 == 0 -> "Buzz"
                else -> number.toString()
            }
        )
    }
}