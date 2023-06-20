package shop.ebusiness

import CreateProductImage
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hka.bloodrecommendationapp.Model.ProductList
import com.hka.bloodrecommendationapp.Model.productList
import shop.ebusiness.ui.theme.*
import shop.ebusiness.util.*

class ShoppingCart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
// q: Can you optimize the following method?

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductView(product: ProductList, content: @Composable () -> Unit) {
    EbusinessTheme {
        Scaffold(
            topBar = {
                Surface(
                    color = Blue80,
                    contentColor = Blue80,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TopAppBar(
                        title = { Text(text = "Shopping Cart") },
                        navigationIcon = { BackIcon() },
                        actions = { ShoppingCartIcon() },
                        modifier = Modifier.background(Color(0xFF4FC0B3))
                    )
                }
            },
            content = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    // Existing code for the Box and other UI elements

                    // Invoke the content composable function and pass the product parameter
                    content()
                }
            }
        )
    }
}

@Composable
fun ProductDetails(product: ProductList) {
    Text(text = "Product Details: ${product.name}")
}

@Preview(showBackground = true)
@Composable
fun ProductPreview() {
    val firstProduct = productList.firstOrNull()
    if (firstProduct != null) {
        ProductView(product = firstProduct) {
            // Pass the product parameter to the ProductDetails composable
        }
    } else {
        // Handle the case when productList is empty
    }
}

@Composable
fun DisplaySize() {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    val screenHeightDp = LocalConfiguration.current.screenHeightDp

    Text("Screen Width: $screenWidthDp dp")
    Text("Screen Height: $screenHeightDp dp")
}
