package ninja.droiddojo.samples.functions.regular

fun main() {

    makePizza(tomatoSauce = true, cheese = true, ham = true, mushrooms = true, mozzarella = true)

    makePizza(true)

    makePizza(tomatoSauce = true, peperoni = true)
}

fun makePizza(
    tomatoSauce: Boolean,
    cheese: Boolean = false,
    ham: Boolean = false,
    salami: Boolean = false,
    mushrooms: Boolean = false,
    peperoni: Boolean = false,
    mozzarella: Boolean = false,
) {
    println("Your Pizza contains:")
    if (tomatoSauce) {
        println("- Tomato Sauce")
    }
    if (cheese) {
        println("- Cheese")
    }
    if (ham) {
        println("- Ham")
    }
    if (salami) {
        println("- Salami")
    }
    if (mushrooms) {
        println("- Mushrooms")
    }
    if (peperoni) {
        println("- Peperoni")
    }
    if (mozzarella) {
        println("- Mozzarella")
    }
}