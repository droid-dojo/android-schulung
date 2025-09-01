package ninja.droiddojo.samples.architecture.shared

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ninja.droiddojo.samples.architecture.shared.common.theme.ArchitectureSampleTheme
import ninja.droiddojo.samples.architecture.shared.data.DataClient
import ninja.droiddojo.samples.architecture.shared.data.User
import ninja.droiddojo.samples.architecture.shared.profile.ProfileScreen

@Composable
fun ArchitectureSampleApp(home: @Composable (onProfileClick: (User) -> Unit) -> Unit) {
    ArchitectureSampleTheme {
        Surface {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    home({ navController.navigate("profile/${it.id}") })
                }

                composable("profile/{userId}") {
                    val user =
                        it.arguments?.getString("userId")?.let { id -> DataClient.findUser(id) }
                    if (user != null) {
                        ProfileScreen(user = user, onBackClick = { navController.popBackStack() })
                    } else {
                        Text(text = "User not found")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ArchitectureSampleApp {
        Text("Sample")
    }
}