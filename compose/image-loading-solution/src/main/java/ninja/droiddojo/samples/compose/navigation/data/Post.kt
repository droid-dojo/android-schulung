package ninja.droiddojo.samples.compose.navigation.data

import ninja.droiddojo.samples.compose.navigation.data.User

data class Post(
    val image: String,
    val author: User,
    val likes: Int = 0,
    val comments: Int = 0
)