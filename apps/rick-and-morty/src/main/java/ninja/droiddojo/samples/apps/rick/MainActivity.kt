package ninja.droiddojo.samples.apps.rick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.work.HiltWorkerFactory
import dagger.hilt.android.AndroidEntryPoint
import ninja.droiddojo.samples.apps.rick.ui.RickTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickTheme {
                RickNavigation()
            }
        }
    }
}



