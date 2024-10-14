package com.shopping.kasbaandroidapp.ui.screens

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shopping.kasbaandroidapp.ui.components.AddIcons
import com.shopping.kasbaandroidapp.ui.components.ButtonComponent
import com.shopping.kasbaandroidapp.ui.components.ClickableLoginTextComponent
import com.shopping.kasbaandroidapp.ui.components.DividerComponent
import com.shopping.kasbaandroidapp.ui.components.HeadingTextComposable
import com.shopping.kasbaandroidapp.ui.components.MyPasswordTextField
import com.shopping.kasbaandroidapp.ui.components.MyTextField
import com.shopping.kasbaandroidapp.ui.components.NormalTextComposable
import com.shopping.kasbaandroidapp.ui.components.UnderlinedTextComposable
import com.shopping.kasbaandroidapp.data.login.LoginUiEvent
import com.shopping.kasbaandroidapp.data.viewmodels.LoginViewModel
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.ui.navigation.SystemBackButtonHandler
import com.shopping.kasbaandroidapp.R

@Composable
fun LoginScreen(
    trySigningIn: (String, String) -> Unit,
    trySigningInUsingGoogle: () -> Unit,
    loginViewModel: LoginViewModel = viewModel()
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
                NormalTextComposable(textValue = stringResource(id = R.string.login))
                HeadingTextComposable(textValue = stringResource(R.string.welcome_back))
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.email),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUiEvent.EmailChange(it))
                    }
                )
                MyPasswordTextField(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.password),
                    onTextSelected = {
                            loginViewModel.onEvent(LoginUiEvent.PasswordChange(it))
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                UnderlinedTextComposable(textValue = stringResource(R.string.forgot_your_password)) {
                    Router.navigateTo(Screen.ForgotPasswordScreen)
                }
                Spacer(modifier = Modifier.height(80.dp))
                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    isEnabled = loginViewModel.allValidationPassed.value
                ) {
                    showLoader.value = true
                    trySigningIn.invoke(loginViewModel.getEmail(), loginViewModel.getPassword())
                    showLoader.value = false
                }

                Spacer(modifier = Modifier.height(20.dp))
                DividerComponent()
                Box(modifier = Modifier.weight(1f)) {
                    AddIcons {
                        if (it == "google"){
                            trySigningInUsingGoogle.invoke()
                        }
                    }
                }
                ClickableLoginTextComponent(
                    txt = stringResource(R.string.don_t_have_an_account),
                    clickableText = stringResource(id = R.string.register)
                ) {
                    Router.navigateTo(Screen.SignUpScreen)
                }
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
        if (loginViewModel.invalidUser.value) {
            Toast.makeText(
                LocalContext.current,
                "Invalid Email or Password",
                Toast.LENGTH_SHORT
            ).show()
            loginViewModel.invalidUser.value = false
        }
    }
}