package ninja.droiddojo.samples.compose.navigation.data

import java.util.UUID
import kotlin.random.Random


object DataClient {

    private val HansPeter = User(
        name = "Hans Peter",
        location = "Germany",
        profilePicture = "",
        id = UUID.randomUUID().toString()
    )

    private val Sergej = User(
        name = "Sergej Fährlich",
        location = "Geheim",
        profilePicture = "",
        id = UUID.randomUUID().toString(),
    )

    private val users = listOf(HansPeter, Sergej)
    private val posts = List(20) {
        Post(
            image = "",
            author = users.random(),
            likes = Random.nextInt(from = 0, until = 100),
            comments = Random.nextInt(from = 0, until = 100)
        )
    }

    fun findUser(userId: String) = users.find { it.id == userId }
    fun allPosts() = posts

}
