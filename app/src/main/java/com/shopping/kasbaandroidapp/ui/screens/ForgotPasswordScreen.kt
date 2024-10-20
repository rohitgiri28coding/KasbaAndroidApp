package com.shopping.kasbaandroidapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shopping.kasbaandroidapp.data.forgotpassword.ForgotPasswordUiEvent
import com.shopping.kasbaandroidapp.data.viewmodels.ForgotPasswordViewModel
import com.shopping.kasbaandroidapp.ui.components.ButtonComponent
import com.shopping.kasbaandroidapp.ui.components.HeadingTextComposable
import com.shopping.kasbaandroidapp.ui.components.MyTextField
import com.shopping.kasbaandroidapp.ui.components.NormalTextComposable
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.ui.navigation.SystemBackButtonHandler
import com.shopping.kasbaandroidapp.ui.theme.Primary
import com.shopping.kasbaandroidapp.R

@Composable
fun ForgotPasswordScreen(forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column {
            HeadingTextComposable(textValue = stringResource(id = R.string.forgot_your_password))
            Spacer(modifier = Modifier.height(25.dp))
            NormalTextComposable(
                textValue = stringResource(R.string.reset_password_msg),
                fontSize = 20.sp,
                color = Primary
            )
            Spacer(modifier = Modifier.height(50.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.email),
                onTextSelected = {
                    forgotPasswordViewModel.onEvent(ForgotPasswordUiEvent.EmailChange(it))
                }
            )
            Spacer(modifier = Modifier.height(50.dp))
            ButtonComponent(
                value = stringResource(R.string.reset_password),
                isEnabled = forgotPasswordViewModel.allValidationPassed.value
            ) {
                forgotPasswordViewModel.onEvent(ForgotPasswordUiEvent.ValidateResetButtonClicked)
            }
        }
        SystemBackButtonHandler {
            Router.navigateTo(Screen.LoginScreen)
        }
    }
}
@Composable
fun ForgotPasswordScreenResetLinkSent(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column {
            HeadingTextComposable(textValue = stringResource(id = R.string.forgot_your_password))
            Spacer(modifier = Modifier.height(25.dp))
            NormalTextComposable(
                textValue = stringResource(R.string.reset_link_sent_msg),
                fontSize = 20.sp,
                color = Primary
            )
            Spacer(modifier = Modifier.height(50.dp))
            ButtonComponent(value = stringResource(id = R.string.login), isEnabled = true) {
                Router.navigateTo(Screen.LoginScreen)
            }
            SystemBackButtonHandler {
                Router.navigateTo(Screen.LoginScreen)
            }
        }
    }
}