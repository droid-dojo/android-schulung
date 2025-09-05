package ninja.droiddojo.samples.apps.rick.character.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import ninja.droiddojo.samples.apps.rick.character.data.CharacterRepository
import ninja.droiddojo.samples.apps.rick.episodes.data.EpisodeRepository
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val characterRepository: CharacterRepository,
    private val episodeRepository: EpisodeRepository,
) : ViewModel() {

    private val args: CharacterDetailRoute = savedStateHandle.toRoute()

    val state: StateFlow<CharacterDetailUiState> = combine(
        characterRepository.findCharacter(args.characterId),
        episodeRepository.findEpisodesForCharacter(args.characterId)
    ) { character, episodes ->
        if (character == null) {
            CharacterDetailUiState.NotFound
        } else {
            CharacterDetailUiState.Content(character = character, episodes = episodes)
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5.seconds),
            initialValue = CharacterDetailUiState.Loading(args.name)
        )

}