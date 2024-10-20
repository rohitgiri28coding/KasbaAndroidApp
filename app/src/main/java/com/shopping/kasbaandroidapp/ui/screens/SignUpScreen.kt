package com.shopping.kasbaandroidapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shopping.kasbaandroidapp.data.signup.SignUpUiEvent
import com.shopping.kasbaandroidapp.data.viewmodels.SignUpViewModel
import com.shopping.kasbaandroidapp.ui.components.ButtonComponent
import com.shopping.kasbaandroidapp.ui.components.DividerComponent
import com.shopping.kasbaandroidapp.ui.components.NormalTextComposable
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel()
){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                NormalTextComposable(textValue = "Looks like you are new to Kasba")
                Spacer(modifier = Modifier.height(30.dp))
                NormalTextComposable("IN +91 395858948xx") // Number to be retrieved from local db
                ButtonComponent(
                    value = "Create an account",
                    isEnabled = true
                ) {
                    signUpViewModel.signUpInProgress.value = true
                    signUpViewModel.onEvent(SignUpUiEvent.RegisterButtonClicked)
                    signUpViewModel.signUpInProgress.value = false
                }
                Spacer(
                    modifier = Modifier
                        .heightIn(20.dp)
                )
                DividerComponent()
                NormalTextComposable("Already a customer?")
                Text("Sign in with other email or number.", modifier = Modifier.clickable { Router.navigateTo(Screen.LoginScreen) })
            }
        }
        if (signUpViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }
}