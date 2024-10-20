package com.shopping.kasbaandroidapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shopping.kasbaandroidapp.ProductDetailedData
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen

class ProductSection {
    @Composable
    fun ProductInColumns(updateId: (Int)->Unit){
        var prod by rememberSaveable {
            mutableStateOf(ProductDetailedData.products)
        }
        val scrollState = rememberScrollState()
        Column (modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()){
            val obj1 = CategoryContent()
            obj1.GenerateLazyRow(onClicked = {category ->
                prod = if (category != "Categories"){
                    ProductDetailedData.products.filter { it.category == category}
                }else{
                    ProductDetailedData.products
                }
            })
            for (i in 0.. prod.size-2 step 2) {
                Row {
                    Box(modifier = Modifier.fillMaxSize(0.5f)) {
                        ProductItem(
                            prod[i].imageSet[0],
                            {
                                showProductFullPage(updateId, i+1)
                            },
                            prod[i].brand+" "+prod[i].category,
                            prod[i].discountOff*prod[i].mrp/100,
                            prod[i].discountOff
                        )
                    }
                    Box(modifier = Modifier.wrapContentSize()) {
                        ProductItem(
                            prod[i+1].imageSet[0],
                            {
                                showProductFullPage(updateId, i+2)
                            },
                            prod[i+1].brand+" "+prod[i+1].category,
                            prod[i+1].discountOff*prod[i+1].mrp/100,
                            prod[i+1].discountOff
                        )
                    }
                }
            }
            for (i in 0.. prod.size-2 step 2) {
                Row {
                    Box(modifier = Modifier.fillMaxSize(0.5f)) {
                        ProductItem(
                            prod[i].imageSet[0],
                            {
                                showProductFullPage(updateId, i+1)
                            },
                            prod[i].brand+" "+prod[i].category,
                            prod[i].discountOff*prod[i].mrp/100,
                            prod[i].discountOff
                        )
                    }
                    Box(modifier = Modifier.wrapContentSize()) {
                        ProductItem(
                            prod[i+1].imageSet[0],
                            {
                                showProductFullPage(updateId, i+2)
                            },
                            prod[i+1].brand+" "+prod[i+1].category,
                            prod[i+1].discountOff*prod[i+1].mrp/100,
                            prod[i+1].discountOff
                        )
                    }
                }
            }
            if (prod.size == 1){
                Row {
                    Box(modifier = Modifier.fillMaxSize(0.5f)) {
                        ProductItem(
                            prod[0].imageSet[0],
                            {
                                showProductFullPage(updateId, 0)
                            },
                            prod[0].brand + " " + prod[0].category,
                            prod[0].discountOff * prod[0].mrp / 100,
                            prod[0].discountOff
                        )
                    }
                    Box(modifier = Modifier.wrapContentSize()) {}
                }
            }

        }
    }


    private fun showProductFullPage(updateId: (Int) -> Unit, i: Int) {
        updateId(i)
        Router.navigateTo(Screen.FullPageProductScreen)
    }

    @Composable
    fun ProductItem(photoResId: Int, onClick: () -> Unit, name: String, price: Int, off: Int) {
        Box(
            modifier = Modifier
                .clickable(onClick = onClick) // Make the item clickable
                .size(380.dp)
                .padding(4.dp)
                .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp))
        ) {
            Column (modifier = Modifier.fillMaxSize()){

                Image(
                    painter = painterResource(id = photoResId),
                    contentDescription = null, // Add appropriate content description if needed
                    contentScale = ContentScale.Fit, // Adjust content scale as needed
                    modifier = Modifier
                        .size(250.dp)
                        .padding(10.dp) // Ensure the image fills the entire clickable area
                )
                AddDetailOfProduct(name = name, price= price, discount= off)
            }
        }
    }
    @Composable
    fun AddDetailOfProduct(name: String, price: Int, discount:Int){

        Column (modifier = Modifier.padding(start = 10.dp)){
            Text(
                text = name,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(top = 4.dp, bottom = 2.dp), maxLines = 2
            )
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "₹ $price",
                    fontFamily = FontFamily.Serif,
                    fontSize = 16.sp,
                )
                Text(
                    text = "$discount% off",
                    fontFamily = FontFamily.Serif,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
            Text(
                text = "Free Delivery",
                fontFamily = FontFamily.Serif,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 2.dp, bottom = 4.dp),

            )
        }
    }

}