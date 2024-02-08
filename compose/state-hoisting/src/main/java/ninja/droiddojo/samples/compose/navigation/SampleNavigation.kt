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

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onProfileClick = { navController.navigate("profile/${it.id}")})
        }

        composable("profile/{userId}") {
            val user = it.arguments?.getString("userId")?.let { id -> DataClient.findUser(id) }
            if (user != null) {
                ProfileScreen(user = user, onBackClick = { navController.popBackStack() })
            } else {
                Text(text = "User not found")
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SampleNavigation()
}