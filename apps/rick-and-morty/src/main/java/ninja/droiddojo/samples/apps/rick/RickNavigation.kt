package ninja.droiddojo.samples.apps.rick

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import ninja.droiddojo.samples.apps.rick.character.detail.CharacterDetailRoute
import ninja.droiddojo.samples.apps.rick.character.detail.characterDetailScreen
import ninja.droiddojo.samples.apps.rick.character.list.CharacterListScreen
import ninja.droiddojo.samples.apps.rick.episodes.list.EpisodeListScreen
import ninja.droiddojo.samples.apps.rick.location.list.LocationsListScreen
import ninja.droiddojo.samples.apps.rick.ui.TopLevelDestination

@Composable
fun RickNavigation(modifier: Modifier = Modifier.Companion) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = EpisodeListRoute) {

        composable<CharacterListRoute> {
            CharacterListScreen(
                onNavigateToCharacter = {
                    navController.navigate(CharacterDetailRoute(it.id, it.name))
                },
                onNavigateToTopDestination = navController::navigateToTopLevelDestination
            )
        }

        characterDetailScreen(
            onNavigateUp = {
                navController.popBackStack(
                    route = CharacterListRoute,
                    inclusive = false
                )
            }
        )


        composable<EpisodeListRoute> {
            EpisodeListScreen(
                onNavigateToEpisode = {
                    navController.navigate(EpisodeDetailRoute(it.id))
                },
                onNavigateToTopDestination = navController::navigateToTopLevelDestination
            )
        }

        composable<EpisodeDetailRoute> {
            TODO()
        }

        composable<LocationListRoute> {
            LocationsListScreen(onNavigateToTopDestination = navController::navigateToTopLevelDestination)
        }
    }
}

private fun NavHostController.navigateToTopLevelDestination(destination: TopLevelDestination) =
    navigate(
        when (destination) {
            TopLevelDestination.Episodes -> EpisodeListRoute
            TopLevelDestination.Characters -> CharacterListRoute
            TopLevelDestination.Locations -> LocationListRoute
        }
    )


@Serializable
data object CharacterListRoute

@Serializable
data object EpisodeListRoute

@Serializable
data class EpisodeDetailRoute(val episodeId: Long)

@Serializable
data object LocationListRoute
