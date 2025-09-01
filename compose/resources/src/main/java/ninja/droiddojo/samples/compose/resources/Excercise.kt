package ninja.droiddojo.samples.compose.resources

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Translations(name: String, weather: Weather) {
    Column {
        //Task 1: Change the implementation to allow the string to be displayed as
        // - "Herzlich Wilkommen" in german
        // - "Welcome" in all other languages
        Text("Welcome!")


        //Task 2: Change the implementation to allow the string to be displayed as
        // - "Wie geht es dir $name?" in german
        // - "How are your $name?" in all other languages
        Text(text = "How are you $name?")


        //Task 3: Change the implementation to allow the string to be displayed as
        // - "Hey, Hans Peter wir haben Sonniges Wetter. Wie findest du das?" in german
        // - "Today's weather is Sunny. How do you feel about this Hans Peter?" in all other languages
        //HINT: The weather should also be translated therefore the extension "displayString" needs to be adjusted

        Text(text = "Today's weather is ${weather.displayString()}. How do you feel about this $name?")
    }
}

@Composable
private fun Weather.displayString(): String = when (this) {
    Weather.Sunny -> "Sunny"
    Weather.Cloudy -> "Cloudy"
}

enum class Weather {
    Sunny, Cloudy
}

@Preview
@Preview(locale = "de")
@Composable
private fun Preview() {
    Surface {
        Translations(name = "Hans Peter", weather = Weather.Sunny)
    }
}