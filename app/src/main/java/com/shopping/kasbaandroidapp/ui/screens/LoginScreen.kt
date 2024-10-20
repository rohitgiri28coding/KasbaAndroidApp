package com.shopping.kasbaandroidapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shopping.kasbaandroidapp.R
import com.shopping.kasbaandroidapp.data.login.LoginUiEvent
import com.shopping.kasbaandroidapp.data.viewmodels.LoginViewModel
import com.shopping.kasbaandroidapp.ui.components.ButtonComponent
import com.shopping.kasbaandroidapp.ui.components.DividerComponent
import com.shopping.kasbaandroidapp.ui.components.HeadingTextComposable
import com.shopping.kasbaandroidapp.ui.components.MyTextField
import com.shopping.kasbaandroidapp.ui.components.NormalTextComposable
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.ui.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val showLoader = remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {
            Column {
                NormalTextComposable(textValue = "Sign in or create account")
                HeadingTextComposable(textValue = stringResource(R.string.welcome_back))
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    labelValue = "Email or mobile number",
                    painterResource = painterResource(id = R.drawable.email),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUiEvent.EmailOrNumberChange(it))
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))

                Spacer(modifier = Modifier.height(80.dp))
                ButtonComponent(
                    value = "Continue",
                    isEnabled = true
                ) {
                    showLoader.value = true
                    loginViewModel.onEvent(LoginUiEvent.ValidateLoginButtonClicked)
                    showLoader.value = false
                }

                Spacer(modifier = Modifier.height(20.dp))
                DividerComponent()
                NormalTextComposable("By continuing you agree to Kasba's Terms & Conditions")
            }
        }
        SystemBackButtonHandler {
            Router.navigateTo(Screen.WelcomeScreen)
        }
        if (showLoader.value) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}