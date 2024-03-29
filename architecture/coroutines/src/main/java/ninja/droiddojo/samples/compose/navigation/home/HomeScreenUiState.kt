package ninja.droiddojo.samples.compose.navigation.home

import ninja.droiddojo.samples.compose.navigation.data.Post

sealed interface HomeScreenUiState {
    data object Loading : HomeScreenUiState
    data class Content(val posts: List<Post>) : HomeScreenUiState
    sealed interface Error : HomeScreenUiState {
        data object NoPosts : Error
        data class ServerError(val code: Int, val message: String) : Error
    }
}