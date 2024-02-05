package ninja.droiddojo.samples.compose.post.solution

data class Post(
    val image: String,
    val author: User,
    val likes: Int = 0,
    val comments: Int = 0
)