package ninja.droiddojo.samples.architecture.shared.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import ninja.droiddojo.samples.architecture.shared.data.User

@Composable
internal fun ProfilePicture(
    user: User,
    size: Dp = 80.dp,
    placeholderColor: Color = Color.LightGray,
    borderColor: Color = Color.Blue,
    onClick: () -> Unit = {}
) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = CircleShape
            )
            .clickable(onClick = onClick),

        model = user.profilePicture, contentDescription = null,
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(placeholderColor)
            )
        },
        error = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(placeholderColor)
            )
        }
    )
}

@Preview
@Composable
private fun Preview() {
    ProfilePicture(User(name = "Hans Peter", location = "Germany", profilePicture = "", id = "1"))
}
