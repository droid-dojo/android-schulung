package ninja.droiddojo.samples.architecture.stateflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ninja.droiddojo.samples.architecture.shared.ArchitectureSampleApp
import ninja.droiddojo.samples.architecture.shared.home.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitectureSampleApp {
                val vm: HomeViewModel = viewModel()
                val state by vm.state.collectAsStateWithLifecycle()
                HomeScreen(uiState = state, onProfileClick = it)
            }
        }
    }
}