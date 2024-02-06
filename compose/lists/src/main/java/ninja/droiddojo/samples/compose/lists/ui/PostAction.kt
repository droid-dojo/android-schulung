package ninja.droiddojo.samples.compose.lists.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun PostAction(
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