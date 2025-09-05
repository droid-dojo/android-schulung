package ninja.droiddojo.samples.apps.rick.episodes.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ninja.droiddojo.samples.apps.rick.episodes.data.Episode
import ninja.droiddojo.samples.apps.rick.ui.RickBottomNavigation
import ninja.droiddojo.samples.apps.rick.ui.TopLevelDestination


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeListScreen(
    modifier: Modifier = Modifier,
    viewModel: EpisodesListScreenViewModel = hiltViewModel(),
    onNavigateToEpisode: (Episode) -> Unit,
    onNavigateToTopDestination: (TopLevelDestination) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Episodes") }
            )
        },
        bottomBar = {
            RickBottomNavigation(
                currentDestination = TopLevelDestination.Episodes,
                onDestinationClick = onNavigateToTopDestination
            )
        },
    ) {
        EpisodesListContent(state = state, modifier = Modifier.padding(it))
    }
}

@Composable
fun EpisodesListContent(state: EpisodeListUiState, modifier: Modifier = Modifier) {
    when (state) {
        is EpisodeListUiState.Content -> LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(state.episodes) {
                ListItem(
                    headlineContent = { Text(it.name) },
                    overlineContent = { Text("S${it.season}E${it.episode}") },
                )
            }
        }

        EpisodeListUiState.Error -> Text("Error", modifier = modifier)
        EpisodeListUiState.Loading -> CircularProgressIndicator(
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize()
        )
    }
}

@PreviewLightDark
@Composable
private fun Preview() {
    EpisodeListScreen(onNavigateToEpisode = {}, onNavigateToTopDestination = {})
}