package com.shopping.kasbaandroidapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shopping.kasbaandroidapp.data.signup.SignUpUiEvent
import com.shopping.kasbaandroidapp.data.viewmodels.SignUpViewModel
import com.shopping.kasbaandroidapp.ui.components.AddIcons
import com.shopping.kasbaandroidapp.ui.components.ButtonComponent
import com.shopping.kasbaandroidapp.ui.components.ClickableLoginTextComponent
import com.shopping.kasbaandroidapp.ui.components.DividerComponent
import com.shopping.kasbaandroidapp.ui.components.HeadingTextComposable
import com.shopping.kasbaandroidapp.ui.components.MyPasswordTextField
import com.shopping.kasbaandroidapp.ui.components.MyTextField
import com.shopping.kasbaandroidapp.ui.components.NormalTextComposable
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.R

@Composable
fun SignUpScreen(
    trySigningUp: (String, String) -> Unit,
    trySigningUpUsingGoogle: () -> Unit,
    signUpViewModel: SignUpViewModel = viewModel()
){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                NormalTextComposable(textValue = stringResource(R.string.hello))
                HeadingTextComposable(textValue = stringResource(R.string.create_an_account))
                Spacer(modifier = Modifier.height(30.dp))
//                MyTextField(
//                    labelValue = stringResource(R.string.first_name),
//                    painterResource = painterResource(id = R.drawable.profile),
//                    onTextSelected = {
//                        signUpViewModel.onEvent(SignUpUiEvent.FirstNameChange(it))
//                    }, errorStatus = signUpViewModel.registrationUiState.value.firstNameError
//                )
//
//                MyTextField(
//                    labelValue = stringResource(R.string.last_name),
//                    painterResource = painterResource(id = R.drawable.profile),
//                    onTextSelected = {
//                        signUpViewModel.onEvent(SignUpUiEvent.LastNameChange(it))
//                    }, errorStatus = signUpViewModel.registrationUiState.value.lastNameError
//                )
                MyTextField(
                    labelValue = stringResource(R.string.email),
                    painterResource = painterResource(id = R.drawable.email),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUiEvent.EmailChange(it))
                    }
                )
                MyPasswordTextField(
                    labelValue = stringResource(R.string.password),
                    painterResource = painterResource(id = R.drawable.password),
                    onTextSelected = {
                        signUpViewModel.onEvent(SignUpUiEvent.PasswordChange(it))
                    }
                )
                Spacer(modifier = Modifier.height(80.dp))
                ButtonComponent(
                    value = stringResource(R.string.register),
                    isEnabled = signUpViewModel.allValidationPassed.value
                ) {
                    signUpViewModel.signUpInProgress.value = true
                    trySigningUp.invoke(signUpViewModel.getEmail(), signUpViewModel.getPassword())
                    signUpViewModel.signUpInProgress.value = false
                }
                Spacer(
                    modifier = Modifier
                        .heightIn(20.dp)
                )
                DividerComponent()
                Box(modifier = Modifier.weight(1f)) {
                    AddIcons {
                          if (it == "google"){
                              trySigningUpUsingGoogle.invoke()
                          }
                    }
                }
                ClickableLoginTextComponent(
                    txt = stringResource(id = R.string.already_have_an_account),
                    clickableText = stringResource(R.string.login)
                ) {
                    Router.navigateTo(Screen.WelcomeScreen)
                }
            }
        }
        if (signUpViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }
}