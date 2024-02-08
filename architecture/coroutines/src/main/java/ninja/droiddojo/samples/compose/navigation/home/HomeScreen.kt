package ninja.droiddojo.samples.compose.navigation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ninja.droiddojo.samples.compose.navigation.common.ui.PostCard
import ninja.droiddojo.samples.compose.navigation.data.DataClient
import ninja.droiddojo.samples.compose.navigation.data.Post
import ninja.droiddojo.samples.compose.navigation.data.User

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onProfileClick: (User) -> Unit
) {
    val state by viewModel.state

    HomeScreen(
        uiState = state,
        onProfileClick = onProfileClick
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    uiState: HomeScreenUiState,
    onProfileClick: (User) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Home") })
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            when (uiState) {
                is HomeScreenUiState.Content -> PostList(
                    posts = uiState.posts,
                    onProfileClick = onProfileClick
                )

                HomeScreenUiState.Error.NoPosts -> EmptyPostsMessage()
                is HomeScreenUiState.Error.ServerError -> ServerError(
                    code = uiState.code,
                    message = uiState.message
                )

                HomeScreenUiState.Loading -> LoadingMessage()
            }
        }
    }
}

@Composable
private fun LoadingMessage() {
    Text(
        text = "Loading..."
    )
}

@Composable
private fun PostList(
    posts: List<Post>,
    modifier: Modifier = Modifier,
    onProfileClick: (User) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(posts) {
            PostCard(post = it, onProfileClick = { onProfileClick(it.author) })
        }
    }
}

@Composable
private fun EmptyPostsMessage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = Icons.Default.PhotoLibrary, contentDescription = null)
        Text(text = "Apparently no Images Exists yet. Be the first one to post one")
    }
}

@Composable
private fun ServerError(
    code: Int,
    message: String,
    onRetryClick: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = Icons.Default.ErrorOutline, contentDescription = null)
        Text(text = "There was an issue with the Server Connection. Please Try Again")
        Text(text = "Error Code: $code")
        Text(text = "Error message: $message")
        Button(onClick = onRetryClick) {
            Text(text = "Retry")
        }
    }
}

@Preview
@Composable
private fun LoadingPreview() {
    HomeScreen(uiState = HomeScreenUiState.Loading)
}

@Preview
@Composable
private fun ContentPreview() {
    HomeScreen(uiState = HomeScreenUiState.Content(posts = DataClient.allPosts()))
}

@Preview
@Composable
private fun NoPostsPreview() {
    HomeScreen(uiState = HomeScreenUiState.Error.NoPosts)
}

@Preview
@Composable
private fun ServerErrorPreview() {
    HomeScreen(
        uiState = HomeScreenUiState.Error.ServerError(
            code = 9999,
            message = "Give me Cookies"
        )
    )
}