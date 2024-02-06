package ninja.droiddojo.samples.functions.regular

fun main() {

    //Task 1:   call the function to bake your favorite pizza. If necessary add missing toppings to the function\

    //Task 2:   Change the function to make use of default arguments so you can call it
    //          with just the ingredients needed using named arguments.
    //          Sample: makePizza(cheese = true, mozzarella = true, tomatoSauce = true)

    makePizza(true, true, false, true, true, false, true)

    makePizza(
        tomatoSauce = true,
        cheese = true,
        ham = false,
        salami = true,
        mushrooms = true,
        peperoni = false,
        mozzarella = true,
    )

    makePizza(
        tomatoSauce = true,
        cheese = true,
        salami = true,
        mushrooms = true,
        mozzarella = true,
        ham = false,
        peperoni = false,
    )

    makePizza(tomatoSauce = true, true, false, true, true, false, true)

}

fun makePizza(
    tomatoSauce: Boolean,
    cheese: Boolean,
    ham: Boolean,
    salami: Boolean,
    mushrooms: Boolean,
    peperoni: Boolean,
    mozzarella: Boolean,
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