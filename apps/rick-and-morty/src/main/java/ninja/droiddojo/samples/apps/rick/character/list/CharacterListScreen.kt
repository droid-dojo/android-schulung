package ninja.droiddojo.samples.apps.rick.character.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import ninja.droiddojo.samples.apps.rick.character.data.Character
import ninja.droiddojo.samples.apps.rick.ui.RickBottomNavigation
import ninja.droiddojo.samples.apps.rick.ui.TopLevelDestination


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterListScreenViewModel = hiltViewModel(),
    onNavigateToCharacter: (Character) -> Unit,
    onNavigateToTopDestination: (TopLevelDestination) -> Unit
) {

    val progress by viewModel.progress.collectAsStateWithLifecycle()
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Characters: $progress") }
            )
        },
        bottomBar = {
            RickBottomNavigation(
                currentDestination = TopLevelDestination.Characters,
                onDestinationClick = onNavigateToTopDestination
            )
        },
    ) {
        CharacterScreenContent(
            state = uiState,
            modifier = Modifier.padding(it),
            onCharacterClick = onNavigateToCharacter
        )
    }
}

@Composable
private fun CharacterScreenContent(
    state: CharacterListScreenState, modifier: Modifier = Modifier,
    onCharacterClick: (Character) -> Unit
) {
    when (state) {
        is CharacterListScreenState.Content -> LazyVerticalGrid(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {

            items(state.characters) {
                CharacterCard(
                    character = it,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onCharacterClick(it) }
                )
            }
        }

        CharacterListScreenState.Error -> Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error
        )

        CharacterListScreenState.Loading -> CircularProgressIndicator()
    }
}

@Composable
fun CharacterCard(character: Character, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier, onClick = onClick,
    ) {
        Row {
            AsyncImage(
                model = character.image,
                modifier = Modifier.size(80.dp),
                contentDescription = null
            )
            Column {
                Text(
                    text = character.name,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
    }
}


@PreviewLightDark
@Composable
private fun Preview() {
    CharacterListScreen(
        onNavigateToCharacter = {},
        onNavigateToTopDestination = {}
    )
}