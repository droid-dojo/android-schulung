package ninja.droiddojo.samples.compose.lists

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ninja.droiddojo.samples.compose.lists.data.Post
import ninja.droiddojo.samples.compose.lists.data.User

@Composable
fun PostList(posts: List<Post>) {

    //Task: Create A Scrollable List that renders all Posts
    //      Between every post should be a spacing of 8.dp
    //Hint: use a LazyList


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