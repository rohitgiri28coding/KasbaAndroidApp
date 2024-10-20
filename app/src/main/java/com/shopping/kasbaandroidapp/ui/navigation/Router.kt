package com.shopping.kasbaandroidapp.ui.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    data object WelcomeScreen: Screen()
    data object LoginScreen: Screen()
    data object OTPScreen: Screen()
    data object SignUpScreen: Screen()
    data object NameScreen: Screen()
    data object TermsAndConditionsScreen: Screen()
    data object ForgotPasswordScreen: Screen()
    data object ForgotPasswordResetLinkSentScreen: Screen()
    data object HomeScreen: Screen()
    data object FullPageProductScreen: Screen()
    data object CartScreen: Screen()
    data object ProfileScreen: Screen()
}

object Router {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.WelcomeScreen)

    fun navigateTo(destination: Screen){
       currentScreen.value = destination
    }
}