package ninja.droiddojo.samples.apps.rick.character.list

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ninja.droiddojo.samples.apps.rick.character.data.sync.CharacterDataSynchronizer
import ninja.droiddojo.samples.apps.rick.character.data.CharacterRepository
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

// DI
// Database -> Prefetch Service

@HiltViewModel
class CharacterListScreenViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
    @ApplicationContext applicationContext: Context
) : ViewModel() {

    val progress = CharacterDataSynchronizer.progress(WorkManager.getInstance(applicationContext))
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5.seconds), -1)

    val state: StateFlow<CharacterListScreenState> = characterRepository.allCharacters().map {
        CharacterListScreenState.Content(it)
    }
        .catch<CharacterListScreenState> {
            Log.e("CharacterListVM", "Error providing state", it)
            emit(CharacterListScreenState.Error)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5.seconds),
            initialValue = CharacterListScreenState.Loading
        )

}