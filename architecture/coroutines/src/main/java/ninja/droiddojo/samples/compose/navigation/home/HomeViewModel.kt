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
    private val _state: MutableState<HomeScreenUiState> = mutableStateOf(HomeScreenUiState.Loading)

    val state: State<HomeScreenUiState> = _state

    init {
        //Task 1: Make the code compile again by ensuring that load data runs in a coroutine scope
//        loadData()
    }

    private suspend fun loadData() {
        _state.value = HomeScreenUiState.Content(
            //Task 2: Ensure that the data is loaded with the IO Context
            posts = DataClient.allPosts()
        )
    }
}
