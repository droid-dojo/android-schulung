package ninja.droiddojo.samples.classes.sealed

import ninja.droiddojo.samples.classes.sealed.Ingredient.Cheese
import ninja.droiddojo.samples.classes.sealed.Ingredient.Cheese.Emmentaler
import ninja.droiddojo.samples.classes.sealed.Ingredient.Cheese.Mozzarella
import ninja.droiddojo.samples.classes.sealed.Ingredient.Cheese.Parmigiano
import ninja.droiddojo.samples.classes.sealed.Ingredient.Meat.Ham
import ninja.droiddojo.samples.classes.sealed.Ingredient.Meat.Salami
import ninja.droiddojo.samples.classes.sealed.Ingredient.Peperoni
import ninja.droiddojo.samples.classes.sealed.Ingredient.TomatoSauce
import ninja.droiddojo.samples.classes.sealed.PizzaSize.Regular
import ninja.droiddojo.samples.classes.sealed.PizzaSize.Small

fun main() {

    val pizzaPeperoni = Pizza(
        ingredients = listOf(
            TomatoSauce,
            Emmentaler,
            Salami,
            Peperoni(spicy = true)
        )
    )


    pizzaPeperoni.bake()

    val pizzaMagarita = Pizza(
        ingredients = listOf(
            TomatoSauce,
            Emmentaler,
            Parmigiano(reggiano = true),
            Mozzarella(creamy = false)
        ),
        size = Small
    )

    pizzaMagarita.bake()

}

private data class Pizza(
    val ingredients: List<Ingredient>,
    val size: PizzaSize = Regular
) {
    val isVegetarian = ingredients.none {
        it is Ingredient.Meat
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
            is Ham -> "Ham"
            is Salami -> "Salami"
            is Mozzarella -> if (creamy) "Burata" else "Mozzarella"
            is Cheese -> "${javaClass.simpleName} (${ageMonths} Months)"
            is Peperoni -> if (spicy) "Peperoni (Spicy)" else "Peperoni"
        }
}

private enum class PizzaSize {
    Small, Regular, FamilySize
}

private sealed interface Ingredient {

    data object TomatoSauce : Ingredient

    sealed interface Meat : Ingredient {
        data object Salami : Meat
        data object Ham : Meat
    }

    data class Peperoni(val spicy: Boolean) : Ingredient

    sealed class Cheese(val ageMonths: Int) : Ingredient {
        data object Emmentaler : Cheese(18)
        data class Parmigiano(val reggiano: Boolean) : Cheese(if (reggiano) 12 else 18)
        data class Mozzarella(val creamy: Boolean) : Cheese(0)
    }
}