package ninja.droiddojo.samples.loops


fun main() {

    val names = listOf("Hans", "Peter", "Silke", "Gerda")

    names.forEach {
        println(it)
    }

    //Alternative 1:
    for (name in names) {
        println(name)
    }

    //Alternative 2:
    for (i in 0..<names.size) {
        println(names[i])
    }
}