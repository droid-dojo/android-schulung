package ninja.droiddojo.samples.compose.states.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

@Composable
fun Circle(
    size: Dp = 80.dp,
    color: Color = Color.LightGray,
    borderColor: Color = Color.Blue
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
    )

}

@Preview
@Composable
private fun Preview() {
    Circle()
}
