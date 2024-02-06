package ninja.droiddojo.samples.compose.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ninja.droiddojo.samples.compose.navigation.data.DataClient
import ninja.droiddojo.samples.compose.navigation.home.HomeScreen
import ninja.droiddojo.samples.compose.navigation.profile.ProfileScreen

@Composable
fun SampleNavigation() {
    
    //Task: Create a Navigation Graph that contains two composable destinations:
    // - "home" -> Should render the HomeScreen composable
    // - "profile" -> Should render the ProfileScreen composable
    //Hint: Both composables already exist

    // Clicking on a profile picture on a Post should navigate to the clicked user.

    // In order to render the ProfileScreen you need to add arguments to the profile route and find the user.
    // There is a `DataClient` class available that offers a `findUser` method.

}

@Preview
@Composable
private fun Preview() {
    SampleNavigation()
}