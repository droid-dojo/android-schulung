package ninja.droiddojo.samples.compose.navigation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ninja.droiddojo.samples.compose.navigation.data.DataClient

class HomeViewModel : ViewModel() {
    private val _state: MutableState<HomeScreenUiState> = mutableStateOf(HomeScreenUiState.Loading)

    val state: State<HomeScreenUiState> = _state

    init {
        _state.value = HomeScreenUiState.Content(DataClient.allPosts())
    }

}