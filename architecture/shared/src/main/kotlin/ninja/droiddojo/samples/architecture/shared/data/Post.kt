package ninja.droiddojo.samples.architecture.shared.data

data class Post(
    val image: String,
    val author: User,
    val likes: Int = 0,
    val comments: Int = 0
)