package ninja.droiddojo.samples.compose.images

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.SubcomposeAsyncImage

@Composable
fun ImageSample() {
    Column {
        SubcomposeAsyncImage(
            model = "https://images.pexels.com/photos/209035/pexels-photo-209035.jpeg",
            loading = { CircularProgressIndicator() },
            error = { Icon(imageVector = Icons.Default.ErrorOutline, contentDescription = null) },
            contentDescription = "Eine Ente",
        )
    }
}

@Preview
@Composable
private fun Preview() {
    // Note: The IDE Preview cannot be loaded, you have to run the sample so see results
    // see: https://coil-kt.github.io/coil/compose/#previews
    ImageSample()
}