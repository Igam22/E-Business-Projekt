import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun getCustomButtonColors(): ButtonColors {
    val contentColor = Color(0xFF4FC0B3)
    return ButtonDefaults.buttonColors(contentColor = contentColor)
}
