package ninja.droiddojo.samples.compose.lists.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ninja.droiddojo.samples.compose.lists.data.User

@Composable
fun UserInfo(
    user: User, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Circle(size = 48.dp)
        Column {
            Text(text = user.name, fontWeight = FontWeight.Bold)
            Text(text = user.location, fontStyle = FontStyle.Italic)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    UserInfo(
        user = User(
            name = "Hans Peter",
            location = "Germany",
            profilePicture = ""
        )
    )
}