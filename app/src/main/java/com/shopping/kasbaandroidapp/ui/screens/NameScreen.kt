package com.shopping.kasbaandroidapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shopping.kasbaandroidapp.R
import com.shopping.kasbaandroidapp.data.signup.NameUiEvent
import com.shopping.kasbaandroidapp.data.viewmodels.NameViewModel
import com.shopping.kasbaandroidapp.ui.components.ButtonComponent
import com.shopping.kasbaandroidapp.ui.components.HeadingTextComposable
import com.shopping.kasbaandroidapp.ui.components.MyTextField
import com.shopping.kasbaandroidapp.ui.components.NormalTextComposable
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.ui.navigation.SystemBackButtonHandler

@Composable
fun NameScreen (nameViewModel: NameViewModel = hiltViewModel()){
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
                HeadingTextComposable(textValue = "Create account")
                Spacer(modifier = Modifier.height(20.dp))
                NormalTextComposable("IN +91 39585xx48x") // Number to be retrieved from local db
                Spacer(modifier = Modifier.height(20.dp))
                HeadingTextComposable(textValue = "First and Last name")
                Spacer(modifier = Modifier.height(40.dp))
                MyTextField(
                    labelValue = "Name",
                    painterResource = painterResource(id = R.drawable.email),
                    onTextSelected = {
                        nameViewModel.onEvent(NameUiEvent.NameChange(it))
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = "Verify mobile number",
                    isEnabled = true
                ) {
                    showLoader.value = true
                    nameViewModel.onEvent(NameUiEvent.ValidateLoginButtonClicked)
                    showLoader.value = false
                }
                Spacer(modifier = Modifier.height(20.dp))
                if(nameViewModel.message.value.isNotBlank()) {
                    Text(nameViewModel.message.value)
                    Log.d("Message",nameViewModel.message.value)
                }
            }
        }
        SystemBackButtonHandler {
            Router.navigateTo(Screen.LoginScreen)
        }
    }
}
