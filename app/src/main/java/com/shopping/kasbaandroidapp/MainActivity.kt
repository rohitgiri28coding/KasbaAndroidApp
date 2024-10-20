package com.shopping.kasbaandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shopping.kasbaandroidapp.ui.app.AppScreenNavigation
import com.shopping.kasbaandroidapp.ui.theme.KasbaAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KasbaAndroidAppTheme {
                AppScreenNavigation()
            }
        }
    }
}