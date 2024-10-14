package com.shopping.kasbaandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.shopping.kasbaandroidapp.ui.theme.KasbaAndroidAppTheme
import com.shopping.kasbaandroidapp.ui.app.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KasbaAndroidAppTheme {
                App()
            }
        }
    }
}