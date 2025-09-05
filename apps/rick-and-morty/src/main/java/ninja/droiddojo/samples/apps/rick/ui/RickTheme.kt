package ninja.droiddojo.samples.apps.rick.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun RickTheme(
    content: @Composable (() -> Unit)
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme(),
        shapes = Shapes(
            medium = CutCornerShape(
                topStart = 8.dp,
                topEnd = 0.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            )
        ),
        content = content
    )
}