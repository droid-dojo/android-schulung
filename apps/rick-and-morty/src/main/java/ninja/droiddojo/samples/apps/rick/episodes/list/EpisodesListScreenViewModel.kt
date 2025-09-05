package ninja.droiddojo.samples.apps.rick.episodes.list

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ninja.droiddojo.samples.apps.rick.episodes.data.EpisodeRepository
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

// DI
// Database -> Prefetch Service

@HiltViewModel
class EpisodesListScreenViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository,
    @ApplicationContext applicationContext: Context
) : ViewModel() {

    val state: StateFlow<EpisodeListUiState> = episodeRepository.allEpisodes().map {
        EpisodeListUiState.Content(it)
    }
        .catch<EpisodeListUiState> {
            Log.e("EpisodeVm", "Error providing state", it)
            emit(EpisodeListUiState.Error)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5.seconds),
            initialValue = EpisodeListUiState.Loading
        )

}