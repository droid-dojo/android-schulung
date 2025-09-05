package ninja.droiddojo.samples.apps.rick.location.list

import android.widget.ImageView
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import ninja.droiddojo.samples.apps.rick.ui.RickBottomNavigation
import ninja.droiddojo.samples.apps.rick.ui.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationsListScreen(
    modifier: Modifier = Modifier,
    onNavigateToTopDestination: (TopLevelDestination) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Locations") }
            )
        },
        bottomBar = {
            RickBottomNavigation(
                currentDestination = TopLevelDestination.Locations,
                onDestinationClick = onNavigateToTopDestination
            )

        },
    ) {
        LazyColumn(
            modifier = Modifier.Companion.padding(it),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(20) {
                Box(
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .background(Color.Companion.Gray)
                )
            }
        }
    }
}


@Composable
fun LegacyDings(modifier: Modifier = Modifier) {

    AndroidView(
        factory = { TextView(it) }
    ) {
        it.text = "Hallo von XML"
    }

}


@PreviewLightDark
@Composable
private fun Preview() {
    LegacyDings()
//    LocationsListScreen(onNavigateToTopDestination = {})
}