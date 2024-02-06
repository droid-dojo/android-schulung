package ninja.droiddojo.samples.compose.navigation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ninja.droiddojo.samples.compose.navigation.common.ui.PostCard
import ninja.droiddojo.samples.compose.navigation.data.DataClient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Home") })
        }
    ) {
        LazyColumn(contentPadding = it, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(DataClient.allPosts()) {
                PostCard(post = it, onProfileClick = { /* TODO */ })
            }
        }
    }
}
