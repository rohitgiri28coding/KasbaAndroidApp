package com.shopping.kasbaandroidapp.ui.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    data object WelcomeScreen: Screen()
    data object SignUpScreen: Screen()
    data object TermsAndConditionsScreen: Screen()
    data object LoginScreen: Screen()
    data object ForgotPasswordScreen: Screen()
    data object ForgotPasswordResetLinkSentScreen: Screen()
    data object HomeScreen: Screen()
}

object Router {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.WelcomeScreen)

    fun navigateTo(destination: Screen){
       currentScreen.value = destination
    }

//    fun chooseAuthOrHome(user: FirebaseUser?){
//        Log.d("chooseAuthOrHome", "$user")
//        if(user == null){
//            currentScreen.value = Screen.LoginScreen
//        }else{
//            currentScreen.value = Screen.HomeScreen
//        }
//    }
}