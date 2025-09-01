package ninja.droiddojo.samples.compose.state.hoisting.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ninja.droiddojo.samples.compose.navigation.data.User

@Composable
fun ProfilePicture(
    user: User,
    size: Dp = 80.dp,
    color: Color = Color.LightGray,
    borderColor: Color = Color.Blue,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = CircleShape
            )
            .clickable(onClick = onClick)
    )

}

@Preview
@Composable
private fun Preview() {
    ProfilePicture(User(name = "Hans Peter", location = "Germany", profilePicture = "", id = "1"))
}
