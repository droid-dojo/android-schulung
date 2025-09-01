package ninja.droiddojo.samples.compose.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ninja.droiddojo.samples.compose.lists.data.Post
import ninja.droiddojo.samples.compose.lists.data.User
import ninja.droiddojo.samples.compose.lists.ui.PostCard

@Composable
fun PostList(posts: List<Post>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(posts) {
            PostCard(post = it)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val posts = List(100) {
        Post(
            image = "",
            author = User(name = "Hans Peter $it", location = "Germany", profilePicture = ""),
        )
    }

    PostList(posts = posts)

}