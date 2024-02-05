package ninja.droiddojo.samples.compose.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Task: Create a Composable called "Circle" that renders a colored Circle with an colored Outline.
// The composable should take the following arguments:
//  - Size -> Dp with default value of 80.dp
//  - color -> Color with default value of Color.LightGray
//  - borderColor -> Color with default value of Color.Blue
