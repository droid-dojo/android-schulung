package ninja.droiddojo.samples.architecture.stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ninja.droiddojo.samples.architecture.shared.data.DataClient
import ninja.droiddojo.samples.architecture.shared.data.FakeNetworkException
import ninja.droiddojo.samples.architecture.shared.home.HomeScreenUiState
import kotlin.time.Duration.Companion.seconds

class HomeViewModel : ViewModel() {

    private val data = flow {
        emit(DataClient.allPostsAsync())
    }
    val state: StateFlow<HomeScreenUiState> = data.map {
        if (it.isEmpty()) HomeScreenUiState.Error.NoPosts else HomeScreenUiState.Content(it)
    }
        .catch {
            when (it) {
                is FakeNetworkException -> emit(
                    HomeScreenUiState.Error.ServerError(
                        code = it.code,
                        message = it.errorMessage
                    )
                )

                else -> emit(
                    HomeScreenUiState.Error.ServerError(
                        code = 9999999,
                        message = "Unknown Error"
                    )
                )
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5.seconds),
            initialValue = HomeScreenUiState.Loading
        )
}
