package ninja.droiddojo.samples.compose.navigation.common.ui

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
import coil.compose.SubcomposeAsyncImage
import ninja.droiddojo.samples.compose.navigation.data.User

@Composable
fun ProfilePicture(
    user: User,
    size: Dp = 80.dp,
    placeholderColor: Color = Color.LightGray,
    borderColor: Color = Color.Blue,
    onClick: () -> Unit = {}
) {
    //TODO: Implement Image Loading Here.
    // The Image should be clickable
    // The image should have the size giben as argument
    // The Image should have a circular shape
    // The Image should have a border of 1.dp and the given color
    // If the Image cannot be loaded it should be displayed as colored with given placeholderColor
    // While the Image is loading it should be displayed as colored with given placeholderColor
}

@Preview
@Composable
private fun Preview() {
    ProfilePicture(User(name = "Hans Peter", location = "Germany", profilePicture = "", id = "1"))
}
