package ninja.droiddojo.samples.classes.solution.sealed

import ninja.droiddojo.samples.classes.sealed.Pizza
import ninja.droiddojo.samples.classes.solution.sealed.PizzaSize.Small
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Cheese.Emmentaler
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Cheese.Mozzarella
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Cheese.Parmigiano
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Meat.Salami
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.Peperoni
import ninja.droiddojo.samples.classes.solution.sealed.ingredients.TomatoSauce

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