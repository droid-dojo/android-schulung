package ninja.droiddojo.samples.compose.lists.data

import ninja.droiddojo.samples.compose.lists.data.User

data class Post(
    val image: String,
    val author: User,
    val likes: Int = 0,
    val comments: Int = 0
)