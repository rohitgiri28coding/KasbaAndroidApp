package com.shopping.kasbaandroidapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.shopping.kasbaandroidapp.ui.components.HeadingTextComposable
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.ui.navigation.SystemBackButtonHandler
import com.shopping.kasbaandroidapp.R

@Composable
fun TermsAndConditionsScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp))
    {
        HeadingTextComposable(textValue = stringResource(R.string.terms_of_use))
        SystemBackButtonHandler {
            Router.navigateTo(Screen.SignUpScreen)
        }
    }
}