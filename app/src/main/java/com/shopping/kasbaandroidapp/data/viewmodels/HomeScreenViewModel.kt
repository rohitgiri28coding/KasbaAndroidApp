package com.shopping.kasbaandroidapp.data.viewmodels

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.ViewModel
import com.shopping.kasbaandroidapp.data.NavigationItem

class HomeScreenViewModel: ViewModel() {

    private val TAG = "HomeScreenViewModel"

    val navigationItemList = listOf(
        NavigationItem(
            title = "Home",
            description = "Home",
            itemId = "01",
            icon = Icons.Filled.Home
        ),
        NavigationItem(
            title = "Courses",
            description = "Courses",
            itemId = "02",
            icon = Icons.AutoMirrored.Filled.MenuBook
        ),
        NavigationItem(
            title = "Contact Us",
            description = "Contact Us",
            itemId = "03",
            icon = Icons.Filled.Call
        ),
        NavigationItem(
            title = "Settings",
            description = "Settings",
            itemId = "04",
            icon = Icons.Filled.Settings
        ),
//        NavigationItem(
//            title = "Logout",
//            description = "Logout",
//            itemId = "04",
//            icon = Icons.AutoMirrored.Filled.Logout
//        )
    )
    fun logout(){

    }
}