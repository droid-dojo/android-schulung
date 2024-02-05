package ninja.droiddojo.samples.classes.sealed

import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Cheese
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Ingredient
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Meat
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Peperoni
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.TomatoSauce
import ninja.droiddojo.samples.classes.solution.sealed.PizzaSize

data class Pizza(
    val ingredients: List<Ingredient>,
    val size: PizzaSize = PizzaSize.Regular
) {
    val isVegetarian = ingredients.none {
        it is Meat
    }

    fun bake() {
        println("Your ${size.name} pizza contains:")

        ingredients.forEach {
            println("- ${it.displayString}")
        }

        if (isVegetarian) {
            println("Your Pizza is vegetarian")
        }
    }

    private val Ingredient.displayString: String
        get() = when (this) {
            is TomatoSauce -> "Tomato Sauce"
            is Meat.Ham -> "Ham"
            is Meat.Salami -> "Salami"
            is Cheese.Mozzarella -> if (creamy) "Burata" else "Mozzarella"
            is Cheese -> "${javaClass.simpleName} (${ageMonths} Months)"
            is Peperoni -> if (spicy) "Peperoni (Spicy)" else "Peperoni"
        }
}