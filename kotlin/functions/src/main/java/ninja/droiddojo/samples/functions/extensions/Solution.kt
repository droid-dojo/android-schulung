package ninja.droiddojo.samples.functions.extensions


fun main() {

    //Task: Revisiting the fizz buzz, the code was changed to make use of extension functions.
    //      These are not yet Implemented so you need to provide them
    repeat(100) { number ->
        println(
            when {
                number.isFizzBuzz() && number % 5 == 0 -> "FizzBuzz"
                number.isFizz() -> "Fizz"
                number.isBuzz() -> "Buzz"
                else -> number.toString()
            }
        )
    }
}

private fun Int.isFizz() = this % 3 == 0
private fun Int.isBuzz() = this % 5 == 0
private fun Int.isFizzBuzz() = isFizz() && isBuzz()