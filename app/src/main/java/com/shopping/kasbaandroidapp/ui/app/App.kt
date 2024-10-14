package com.shopping.kasbaandroidapp.ui.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.shopping.kasbaandroidapp.home.ProductLists
import com.shopping.kasbaandroidapp.productdescription.ProductDescription
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.ui.screens.ForgotPasswordScreen
import com.shopping.kasbaandroidapp.ui.screens.ForgotPasswordScreenResetLinkSent
import com.shopping.kasbaandroidapp.ui.screens.LoginScreen
import com.shopping.kasbaandroidapp.ui.screens.SignUpScreen
import com.shopping.kasbaandroidapp.ui.screens.TermsAndConditionsScreen
import com.shopping.kasbaandroidapp.ui.screens.WelcomeScreen

@Composable
fun App( ){
    var id by remember {
        mutableIntStateOf(0)
    }
//    var user by rememberSaveable {
//        mutableStateOf(auth.currentUser)
//    }
    // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize()) {
        Crossfade(targetState = Router.currentScreen, label = "") { currentState->
            when(currentState.value){
                Screen.WelcomeScreen ->{
                    WelcomeScreen()
                }
                Screen.SignUpScreen -> {
                    SignUpScreen(
                        trySigningUp = { email, password ->
                            Router.navigateTo(Screen.HomeScreen)
//                            scope.launch {
//                                user = firebaseBasicAuth.signUp(email = email, password = password)
//                            }
                        },
                        trySigningUpUsingGoogle = {
                            Router.navigateTo(Screen.HomeScreen)
//                            scope.launch {
//                                user = googleAuth.authenticateWithGoogle()
//                                Router.chooseAuthOrHome(user)
//                            }
                        },
                    )
                }
                Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }
                Screen.LoginScreen -> {
                    LoginScreen(
                        trySigningIn = { email, password ->
                            Router.navigateTo(Screen.HomeScreen)

//                            scope.launch {
//                                user = firebaseBasicAuth.signIn(email = email, password = password)
//                            }
                        },
                        trySigningInUsingGoogle = {
                            Router.navigateTo(Screen.HomeScreen)
//                            scope.launch {
//                                user = googleAuth.authenticateWithGoogle()
//                                Router.chooseAuthOrHome(user)
//                            }
                        },
                    )
                }
                Screen.ForgotPasswordScreen -> {
                    ForgotPasswordScreen()
                }
                Screen.HomeScreen -> {
                    val obj = ProductLists()
                    obj.ProductListing{
                        id = it
                    }

                }
                Screen.ProductDescription ->{
                    val obj = ProductDescription()
                    obj.LoadProductInFullPage(id = id)
                }
                Screen.ForgotPasswordResetLinkSentScreen -> {
                    ForgotPasswordScreenResetLinkSent()
                }
            }
        }
    }
}