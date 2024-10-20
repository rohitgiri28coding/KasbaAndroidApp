package com.shopping.kasbaandroidapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.shopping.kasbaandroidapp.data.OTPUiEvent
import com.shopping.kasbaandroidapp.data.login.LoginUiEvent
import com.shopping.kasbaandroidapp.data.viewmodels.OTPViewModel
import com.shopping.kasbaandroidapp.ui.components.ButtonComponent
import com.shopping.kasbaandroidapp.ui.components.DividerComponent
import com.shopping.kasbaandroidapp.ui.components.HeadingTextComposable
import com.shopping.kasbaandroidapp.ui.components.MyTextField
import com.shopping.kasbaandroidapp.ui.components.NormalTextComposable
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.ui.navigation.SystemBackButtonHandler

@Composable
fun OTPScreen(otpViewModel: OTPViewModel = hiltViewModel()) {
    val showLoader = remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {
            Column {
                NormalTextComposable(textValue = "Verify mobile number")
                Spacer(modifier = Modifier.height(20.dp))
                NormalTextComposable("IN +91 395858948x") // Number to be retrieved from local db
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    labelValue = "OTP",
                    painterResource = painterResource(id = R.drawable.email),
                    onTextSelected = {
                        otpViewModel.onEvent(OTPUiEvent.OTPChange(it))
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = "Create account",
                    isEnabled = true

                ) {
                    showLoader.value = true
                    Router.navigateTo(Screen.HomeScreen)
                    showLoader.value = false
                }

                Spacer(modifier = Modifier.height(20.dp))
                ButtonComponent(
                    value = "Resend OTP",
                    isEnabled = true
                ) {
                    showLoader.value = true

                    showLoader.value = false
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        SystemBackButtonHandler {
            Router.navigateTo(Screen.LoginScreen)
        }
    }
}
