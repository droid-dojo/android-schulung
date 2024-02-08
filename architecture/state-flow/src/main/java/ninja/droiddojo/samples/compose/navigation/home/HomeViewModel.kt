package ninja.droiddojo.samples.compose.navigation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ninja.droiddojo.samples.compose.navigation.data.DataClient

class HomeViewModel : ViewModel() {

    //Task: Change the type from MutableState to MutableStateFlow
    private val _state: MutableState<HomeScreenUiState> = mutableStateOf(HomeScreenUiState.Loading)

    //Task: Change the type from State to StateFlow
    val state: State<HomeScreenUiState> = _state

    init {
        viewModelScope.launch { loadData() }
    }

    private suspend fun loadData() {
        //Task: Change the value assignment to be concurrency safe
        _state.value = HomeScreenUiState.Content(
            posts = withContext(Dispatchers.IO) { DataClient.allPosts() }
        )
    }

}