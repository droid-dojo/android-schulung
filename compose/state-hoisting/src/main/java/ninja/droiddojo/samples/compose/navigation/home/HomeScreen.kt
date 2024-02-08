package ninja.droiddojo.samples.compose.navigation.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ninja.droiddojo.samples.compose.navigation.data.Post
import ninja.droiddojo.samples.compose.navigation.data.User

//Task: Create a class structure that can represent the following ui states:
// - Loading
// - Posts
// - No Posts Available
// - Server Error

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onProfileClick: (User) -> Unit) {
    //Task: Create a State Hoisted Variant of the Home Screen
    //Task: Create Previews for every possible State
}


