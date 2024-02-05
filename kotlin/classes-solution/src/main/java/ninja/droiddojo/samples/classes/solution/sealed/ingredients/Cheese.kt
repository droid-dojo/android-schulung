package ninja.droiddojo.samples.classes.solution.sealed.ingredients

sealed class Cheese(val ageMonths: Int) : Ingredient {
    data object Emmentaler : Cheese(18)
    data class Parmigiano(val reggiano: Boolean) : Cheese(if (reggiano) 12 else 18)
    data class Mozzarella(val creamy: Boolean) : Cheese(0)
}