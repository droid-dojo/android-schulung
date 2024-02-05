package ninja.droiddojo.samples.compose.basics

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UserInfo(name: String, location: String) {
    // Task: Create a Composable that Renders a Circle next to a Text containing the given name and another text containing the location below
    // The Circle should have a size of 48.dp
    // The Circle and the texts should have a spacing of 8.dp
    // The texts should be aligned centered to the circle
    // The name should be displayed bold
    // The location should be displayed italics
}

@Preview
@Composable
private fun Preview() {
    UserInfo(name = "Hans Peter", location = "Germany")
}