package ninja.droiddojo.samples.compose.basics.solution

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting(name: String) {
    Text("Hello $name! How are you?")
}

@Preview
@Composable
private fun Preview() {
    Greeting(name = "Hans Peter")
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    Greeting(name = "Magda")
}