package ninja.droiddojo.samples.compose.navigation.common.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import ninja.droiddojo.samples.compose.navigation.data.Post
import ninja.droiddojo.samples.compose.navigation.data.User
import java.util.UUID


@Composable
fun PostCard(post: Post, onProfileClick: () -> Unit = {}) {
    Card {
        UserInfo(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            user = post.author,
            onProfilePictureClick = onProfileClick
        )
        PostImage(post)
        PostActions(likes = post.likes, comments = post.comments)
    }
}


@Composable
private fun PostActions(likes: Int, comments: Int) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        LikeButton(likes = likes)
        PostAction(icon = Icons.AutoMirrored.Default.Comment, text = "$comments", onClick = {})
    }
}


@Composable
private fun PostImage(post: Post) {
    //TODO: Implement Image Loading.
    // The Image should have maximum width and an aspect ratio of 16f/9f
    // The Images should be center cropped
    // If the Images cant be loaded it should display an Icon
}

@Preview
@Composable
private fun Preview() {
    PostCard(
        post = Post(
            image = "",
            author = User(
                name = "Hans Peter",
                location = "Germany",
                profilePicture = "",
                id = UUID.randomUUID().toString()
            ),
        )
    )
}