package ninja.droiddojo.samples.apps.rick.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun RickBottomNavigation(
    currentDestination: TopLevelDestination,
    modifier: Modifier = Modifier,
    onDestinationClick: (TopLevelDestination) -> Unit
) {
    NavigationBar(modifier = modifier) {
        TopLevelDestination.entries.forEach {
            NavigationBarItem(
                selected = currentDestination == it,
                onClick = { onDestinationClick(it) },
                icon = { Icon(imageVector = it.navigationIcon, contentDescription = null) }
            )
        }
    }
}


enum class TopLevelDestination {
    Episodes, Characters, Locations
}

private val TopLevelDestination.navigationIcon: ImageVector
    get() = when (this) {
        TopLevelDestination.Episodes -> Icons.Default.Movie
        TopLevelDestination.Characters -> Icons.Default.Person
        TopLevelDestination.Locations -> Icons.Default.Map
    }

