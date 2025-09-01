package ninja.droiddojo.samples.architecture.stateflow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import ninja.droiddojo.samples.architecture.shared.home.HomeScreenUiState

class HomeViewModel : ViewModel() {
    val state: StateFlow<HomeScreenUiState> = TODO()
    //Task: Load data asynchronous from DataClient and provide as StateFlow
}
