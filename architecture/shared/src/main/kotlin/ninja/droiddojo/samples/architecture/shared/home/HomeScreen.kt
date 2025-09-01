package ninja.droiddojo.samples.architecture.shared.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ninja.droiddojo.samples.architecture.shared.common.ui.PostCard
import ninja.droiddojo.samples.architecture.shared.data.Post
import ninja.droiddojo.samples.architecture.shared.data.User
import java.util.UUID
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: HomeScreenUiState,
    onProfileClick: (User) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Home") })
        }) {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 8.dp)
                .fillMaxSize()
                .wrapContentSize()
        ) {
            when (uiState) {
                is HomeScreenUiState.Content -> PostList(
                    posts = uiState.posts, onProfileClick = onProfileClick
                )

                HomeScreenUiState.Error.NoPosts -> EmptyPostsMessage()
                is HomeScreenUiState.Error.ServerError -> ServerError(
                    code = uiState.code, message = uiState.message
                )

                HomeScreenUiState.Loading -> CircularProgressIndicator()
            }
        }
    }
}

@Composable
private fun PostList(
    posts: List<Post>, modifier: Modifier = Modifier, onProfileClick: (User) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(posts) {
            PostCard(
                post = it,
                onProfileClick = { onProfileClick(it.author) })
        }
    }
}

@Composable
private fun EmptyPostsMessage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.PhotoLibrary,
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Text(
            style = MaterialTheme.typography.titleMedium, text = "Apparently no Images Exists yet"
        )
        Text("Be the first one to post one")
    }
}

@Composable
private fun ServerError(
    code: Int, message: String, onRetryClick: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.ErrorOutline,
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = MaterialTheme.colorScheme.error
        )
        Text(
            text = "There was an issue with the Server Connection. Please Try Again",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
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
    HomeScreen(uiState = HomeScreenUiState.Content(posts = List(20) {
        Post(
            image = "",
            author = User(
                name = "Hans Peter",
                location = "Germany",
                profilePicture = "",
                id = UUID.randomUUID().toString()
            ),
            likes = Random.nextInt(from = 0, until = 100),
            comments = Random.nextInt(from = 0, until = 100)
        )
    }))
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
            code = 9999, message = "Give me Cookies"
        )
    )
}