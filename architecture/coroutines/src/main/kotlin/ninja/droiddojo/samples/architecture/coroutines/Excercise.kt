package ninja.droiddojo.samples.architecture.coroutines

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ninja.droiddojo.samples.architecture.shared.data.DataClient
import ninja.droiddojo.samples.architecture.shared.home.HomeScreenUiState

class HomeViewModel : ViewModel() {
    private val _state: MutableState<HomeScreenUiState> = mutableStateOf(HomeScreenUiState.Loading)

    val state: State<HomeScreenUiState> = _state

    init {
        //Task 1: Make the code compile again by ensuring that load data runs in a coroutine scope
        _state.value = HomeScreenUiState.Content(
            //Task 2: Ensure that the data is loaded with the IO Context
            posts = DataClient.allPostsAsync()
        )
    }
}