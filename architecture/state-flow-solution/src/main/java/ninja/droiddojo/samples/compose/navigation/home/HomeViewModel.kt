package ninja.droiddojo.samples.compose.navigation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ninja.droiddojo.samples.compose.navigation.data.DataClient

class HomeViewModel : ViewModel() {
    private val _state: MutableStateFlow<HomeScreenUiState> =
        MutableStateFlow(HomeScreenUiState.Loading)

    val state = _state.asStateFlow()

    init {
        viewModelScope.launch { loadData() }
    }

    private suspend fun loadData() {
        _state.update {
            HomeScreenUiState.Content(
                posts = withContext(Dispatchers.IO) { DataClient.allPosts() }
            )
        }
    }

}