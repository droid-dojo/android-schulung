package ninja.droiddojo.samples.classes.solution.sealed.ingredients

sealed interface Meat : Ingredient {
    data object Salami : Meat
    data object Ham : Meat
}