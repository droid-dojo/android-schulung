package ninja.droiddojo.samples.apps.rick.character.detail

import ninja.droiddojo.samples.apps.rick.character.data.Character
import ninja.droiddojo.samples.apps.rick.episodes.data.Episode

sealed interface CharacterDetailUiState {

    val name: String

    data class Loading(override val name: String) : CharacterDetailUiState
    data class Content(val character: Character, val episodes: List<Episode>) :
        CharacterDetailUiState {
        override val name: String
            get() = character.name
    }

    data object NotFound : CharacterDetailUiState {
        override val name: String
            get() = "Error"

    }
}