package ninja.droiddojo.samples.apps.rick.character.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import ninja.droiddojo.samples.apps.rick.character.data.Character
import ninja.droiddojo.samples.apps.rick.episodes.data.Episode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterDetailViewModel = hiltViewModel(),
    onNavigateUp: () -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text(state.name) }, navigationIcon = {
            IconButton(onClick = { onNavigateUp() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null
                )
            }
        })
    }, content = { CharacterDetailScreen(state, Modifier.padding(it)) })

}

@Composable
private fun CharacterDetailScreen(state: CharacterDetailUiState, modifier: Modifier = Modifier) {
    when (state) {
        is CharacterDetailUiState.Content -> CharacterDetailContent(state, modifier)
        is CharacterDetailUiState.Loading -> CircularProgressIndicator(
            modifier
                .fillMaxSize()
                .wrapContentSize()
        )

        CharacterDetailUiState.NotFound -> Icon(
            imageVector = Icons.Default.QuestionMark,
            tint = MaterialTheme.colorScheme.error,
            contentDescription = null
        )
    }
}

@Composable
private fun CharacterDetailContent(
    state: CharacterDetailUiState.Content, modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {

        item {
            CharacterDetails(state.character)
        }

        item {
            Text(
                text = "Episodes (${state.episodes.size}):",
                style = MaterialTheme.typography.headlineLarge
            )
        }

        items(state.episodes) {
            EpisodeItem(it)
        }
    }
}

@Composable
private fun CharacterDetails(character: Character, modifier: Modifier = Modifier) {
    ListItem(modifier = modifier, headlineContent = { Text(character.name) }, leadingContent = {
        AsyncImage(character.image, contentDescription = character.name)
    })
}

@Composable
private fun EpisodeItem(episode: Episode, modifier: Modifier = Modifier) {
    ListItem(
        modifier = modifier,
        headlineContent = { Text(episode.name) },
        trailingContent = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        },
    )
}

@Preview
@Composable
private fun Preview() {
    CharacterDetailScreen(
        onNavigateUp = {})
}