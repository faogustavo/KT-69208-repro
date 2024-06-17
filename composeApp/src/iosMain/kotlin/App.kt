import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIImage
import platform.UIKit.UIImageView

@OptIn(ExperimentalForeignApi::class)
@Composable
fun App() {
    MaterialTheme {
        val uiImage = remember { UIImage.systemImageNamed("arrow.clockwise") }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var target by remember { mutableStateOf(0f) }
            val rotation by animateFloatAsState(target)

            UIKitView(
                factory = { UIImageView(uiImage) },
                modifier = Modifier.size(40.dp)
                    .graphicsLayer { rotationZ = rotation }
                    .border(1.dp, Color.Blue),
            )

            Button(
                onClick = { target += 90 },
                modifier = Modifier.padding(top = 48.dp)
            ) {
                Text("Rotate")
            }
        }
    }
}