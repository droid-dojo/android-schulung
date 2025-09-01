package ninja.droiddojo.samples.architecture.shared.data

import kotlinx.coroutines.delay
import java.util.UUID
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds


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
        profilePicture = "https://cdn.pixabay.com/photo/2016/01/18/20/11/old-man-1147288_1280.jpg",
        id = UUID.randomUUID().toString(),
    )

    private val users = listOf(HansPeter, Sergej)

    private val images = listOf(
        "https://cdn.pixabay.com/photo/2024/01/08/15/54/defile-8495836_1280.jpg",
        "https://cdn.pixabay.com/photo/2024/01/27/18/24/squirrel-8536537_1280.jpg",
        "https://cdn.pixabay.com/photo/2023/08/17/09/29/rock-8196075_1280.jpg",
        "https://cdn.pixabay.com/photo/2017/10/10/07/48/beach-2836300_1280.jpg",
        "https://cdn.pixabay.com/photo/2018/02/15/21/55/sunset-3156440_1280.jpg",
        "https://cdn.pixabay.com/photo/2015/07/05/10/18/tree-832079_1280.jpg",
        "https://invalid.url/not/existing",
    )

    private val posts = List(20) {
        Post(
            image = images.random(),
            author = users.random(),
            likes = Random.nextInt(from = 0, until = 100),
            comments = Random.nextInt(from = 0, until = 100)
        )
    }


    fun findUser(userId: String): User? {
        return users.find { it.id == userId }
    }


    fun allPosts(): List<Post> {
        return posts
    }

    suspend fun allPostsAsync(error: Boolean = false): List<Post> {
        delay(5.seconds)
        if (error) {
            throw FakeNetworkException(code = Random.nextInt(400, 499), errorMessage = "Ooooops!")
        } else {
            return posts
        }
    }

}

