package com.shopping.kasbaandroidapp.productdescription

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shopping.kasbaandroidapp.R
import com.shopping.kasbaandroidapp.home.TopAppBarHome
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen

class TopAppBarProduct {
    @Composable
    fun TopAppBarCommon() {
        Row {
            IconButton(onClick = { Router.navigateTo(Screen.HomeScreen) }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Back Button",
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxSize()
                )
            }
            val obj = TopAppBarHome()
            obj.AddSearchBar(modifier = Modifier)
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "Cart"
                )
            }
        }
    }
}