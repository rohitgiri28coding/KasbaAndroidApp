package com.shopping.kasbaandroidapp.ui.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.shopping.kasbaandroidapp.data.viewmodels.AuthViewModel
import com.shopping.kasbaandroidapp.home.ProductListing
import com.shopping.kasbaandroidapp.productdescription.LoadProductInFullPage
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.ui.screens.CartScreen
import com.shopping.kasbaandroidapp.ui.screens.ForgotPasswordScreen
import com.shopping.kasbaandroidapp.ui.screens.ForgotPasswordScreenResetLinkSent
import com.shopping.kasbaandroidapp.ui.screens.LoginScreen
import com.shopping.kasbaandroidapp.ui.screens.NameScreen
import com.shopping.kasbaandroidapp.ui.screens.OTPScreen
import com.shopping.kasbaandroidapp.ui.screens.ProfileScreen
import com.shopping.kasbaandroidapp.ui.screens.SignUpScreen
import com.shopping.kasbaandroidapp.ui.screens.TermsAndConditionsScreen
import com.shopping.kasbaandroidapp.ui.screens.WelcomeScreen

@Composable
fun AppScreenNavigation(authViewModel: AuthViewModel = hiltViewModel()){
    Surface(modifier = Modifier.fillMaxSize()) {
        Crossfade(targetState = Router.currentScreen, label = "") { currentState->
            when(currentState.value){
                Screen.WelcomeScreen -> WelcomeScreen()
                Screen.CartScreen -> CartScreen()
                Screen.ForgotPasswordResetLinkSentScreen -> ForgotPasswordScreenResetLinkSent()
                Screen.ForgotPasswordScreen -> ForgotPasswordScreen()
                Screen.FullPageProductScreen -> LoadProductInFullPage()
                Screen.HomeScreen -> ProductListing {  }
                Screen.LoginScreen -> LoginScreen()
                Screen.NameScreen -> NameScreen()
                Screen.OTPScreen -> OTPScreen()
                Screen.ProfileScreen -> ProfileScreen()
                Screen.SignUpScreen -> SignUpScreen()
                Screen.TermsAndConditionsScreen -> TermsAndConditionsScreen()
            }
        }
    }
}