package shop.ebusiness

import CreateProductImage
import DbManager
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shop.ebusiness.model.ProductList
import shop.ebusiness.ui.theme.*
import shop.ebusiness.util.*

class ShoppingCart : ComponentActivity() {
    private lateinit var dbManager: DbManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbManager = DbManager(this)
        dbManager.open()

        setContent {
            ProductPreview()
        }
    }


    @Composable
    fun ProductDetails(product: ProductList) {
        Text(text = "Product Details: ${product.name}")
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProductView(product : ProductList, content: @Composable () -> Unit) {
        EbusinessTheme {
            Scaffold(
                topBar = {
                    Surface(
                        color = Blue80,
                        contentColor = Blue80, // Set the background color here
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
                        // Hintergrundkreise
                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .offset((-190).dp, (-290).dp)
                                .background(Color(0x804FC0B3), shape = CircleShape)
                        )
                        // Hintergrundkreise
                        Box(
                            modifier = Modifier
                                .size(200.dp)
                                .offset((-100).dp, (-350).dp)
                                .background(Color(0x804FC0B3), shape = CircleShape)
                        )

                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.weight(1f))

                            // Produktname als Überschrift
                            Row(
                                modifier = Modifier.weight(0.5f),
                                horizontalArrangement = Arrangement.Center
                            )
                            // Anzeigen des Produktnamens
                            {
                                Text(
                                    text = product.name,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        color = Color(0xFF2A6F62)
                                    ),
                                    modifier = Modifier.padding(vertical = 8.dp),
                                    textAlign = TextAlign.Center
                                )

                            }

                            Row(
                                modifier = Modifier.weight(1f),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                // Anzeigen des Produktbildes
                                CreateProductImage()
                            }

                            Row(
                                modifier = Modifier
                                    .weight(1f)
                                    .width(392.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Column(
                                    modifier = Modifier
                                        .weight(2f)
                                        .height(40.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    // Anzeige des Preises unter dem Bild
                                    Text(text = product.pr.toString() + " €/kg",
                                        style = MaterialTheme.typography.bodyLarge , // Set the text style to MaterialTheme typography with h6 style
                                        fontWeight = FontWeight.Bold, // Set the text weight to bold
                                        fontSize = 20.sp)

                                }

                                Column(
                                    modifier = Modifier
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    // Menge verringern
                                    DecreaseIcon()
                                }

                                Column(
                                    modifier = Modifier
                                        .weight(1f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    // Column 2
                                    Text(text = " 100g ",
                                        style = MaterialTheme.typography.bodyLarge , // Set the text style to MaterialTheme typography with h6 style
                                        fontWeight = FontWeight.Bold, // Set the text weight to bold
                                        fontSize = 20.sp)
                                    // Weitere Inhalte für Spalte 2
                                }

                                Column(
                                    modifier = Modifier
                                        .weight(1f),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    AddIcon()
                                }
                            }


                            // Produktbeschreibung
                            Row(
                                modifier = Modifier.weight(0.5f).height(4.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = product.her,
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        color = Color(0xFF2A6F62)
                                    ),
                                    modifier = Modifier.padding(vertical = 8.dp),
                                    textAlign = TextAlign.Center
                                )
                            }

                            Row(
                                modifier = Modifier.weight(1f),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                DisplayDescription(product)
                            }

                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            )
        }
    }


    @Composable
    fun ProductDetails(){
        Text(text = "Produkt Details")
    }

    val product = ProductList().apply { name = "Erdbeeren"; her = "Hersteller"; pr = 4.99; war = "Erntefrische Erdebberen in demeter Bio-Qualität. Fruchtig, Süß und saftig." }



    @Preview(showBackground = true)
    @Composable
    fun ProductPreview() {
        ProductView(product, content = { ProductDetails() })
    }




    @Composable
    fun DisplayDescription(product: ProductList) {
        Surface(
            color = Color.White, // Set the background color of the box to white
            shape = RoundedCornerShape(8.dp), // Set the shape of the box (rounded corners)
            border = BorderStroke(1.dp, Color(0xFF348077)), // Set the border color and width
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp) // Set the padding
        ) {
            Text(
                text = product.war,
                style = MaterialTheme.typography.bodyLarge, // Apply the desired Material font style
                modifier = Modifier.padding(8.dp) // Set the padding within the box
            )
        }
    }
        
    }