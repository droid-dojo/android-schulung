package ninja.droiddojo.samples.apps.rick.character.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDetailRoute(val characterId: Long, val name: String)

fun NavGraphBuilder.characterDetailScreen(onNavigateUp: () -> Unit) {
    composable<CharacterDetailRoute> {
        CharacterDetailScreen(onNavigateUp = onNavigateUp)
    }
}