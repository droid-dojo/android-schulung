package ninja.droiddojo.samples.compose.states

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ninja.droiddojo.samples.compose.states.ui.PostAction

@Composable
fun LikeButton(likes: Int) {
    //Task: Implement that clicking the like button toggles the users liked state
    // If the user has liked the Post:
    // - change the Icon to Favorite
    // - change the like amount to + 1
    // If the user has not liked the Post:
    // - change the Icon to FavoriteBorder
    // - display the original like amount


    PostAction(
        icon = Icons.Default.FavoriteBorder,
        text = "$likes",
        onClick = {}
    )
}


@Preview
@Composable
private fun Preview() {
    LikeButton(likes = 20)
}