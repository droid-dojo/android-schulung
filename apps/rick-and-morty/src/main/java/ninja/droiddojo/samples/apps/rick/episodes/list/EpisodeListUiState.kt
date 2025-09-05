package ninja.droiddojo.samples.apps.rick.episodes.list

import ninja.droiddojo.samples.apps.rick.episodes.data.Episode

sealed interface EpisodeListUiState {
    object Loading : EpisodeListUiState
    object Error : EpisodeListUiState
    data class Content(
        val episodes: List<Episode>
    ) : EpisodeListUiState
}