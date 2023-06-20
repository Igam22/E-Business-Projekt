package shop.ebusiness.util

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class Buttons {


}@Composable
fun BackIcon(){
    Surface(
        color = Color(0xFF4FC0B3), // Set the background color here
        shape = CircleShape
    ){
        IconButton(
            onClick = {}
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun ShoppingCartIcon() {
    Surface(
        color = Color(0xFF4FC0B3), // Set the background color here
        shape = CircleShape
    ) {
        IconButton(
            onClick = { /* Handle shopping cart icon click here */ }
        )
        {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Shopping Cart",
                tint = MaterialTheme.colorScheme.onSurface

            )
        }
    }}