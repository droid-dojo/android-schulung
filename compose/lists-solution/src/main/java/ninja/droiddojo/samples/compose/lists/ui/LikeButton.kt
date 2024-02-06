package ninja.droiddojo.samples.compose.lists.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LikeButton(likes: Int) {
    var liked by remember { mutableStateOf(false) }

    val actualLikes = remember(liked, likes) {
        if (liked) likes + 1 else likes
    }

    PostAction(
        icon = if (liked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
        text = "$actualLikes",
        onClick = { liked = !liked }
    )
}


@Preview
@Composable
private fun Preview() {
    LikeButton(likes = 20)
}