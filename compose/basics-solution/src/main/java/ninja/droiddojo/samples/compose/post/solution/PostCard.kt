package ninja.droiddojo.samples.compose.post.solution

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ninja.droiddojo.samples.compose.basics.solution.UserInfo

@Composable
fun PostCard(post: Post) {
    Card {
        UserInfo(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            name = post.author.name, location = post.author.location
        )
        PostImage()
        PostActions(likes = post.likes, comments = post.comments)
    }

}


@Composable
private fun PostActions(likes: Int, comments: Int) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        PostAction(icon = Icons.Default.FavoriteBorder, text = "$likes", onClick = {})
        PostAction(icon = Icons.AutoMirrored.Default.Comment, text = "$comments", onClick = {})
    }
}

@Composable
private fun PostAction(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
) {
    TextButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = text)
    }
}

@Composable
private fun PostImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .background(Color.LightGray)
    )
}

@Preview
@Composable
private fun Preview() {
    PostCard(
        post = Post(
            image = "",
            author = User(name = "Hans Peter", location = "Germany", profilePicture = ""),
        )
    )
}