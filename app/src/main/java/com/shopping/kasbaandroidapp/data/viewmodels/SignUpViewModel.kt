package com.shopping.kasbaandroidapp.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shopping.kasbaandroidapp.data.signup.RegistrationUiState
import com.shopping.kasbaandroidapp.data.signup.SignUpUiEvent
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel() {

    private var registrationUiState = mutableStateOf(RegistrationUiState())

    var signUpInProgress = mutableStateOf(false)
    fun onEvent(event: SignUpUiEvent){
        when(event){
            is SignUpUiEvent.PhoneNumberChange -> {
                registrationUiState.value = registrationUiState.value.copy(
                    email = event.email
                )
            }
            SignUpUiEvent.RegisterButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        Router.navigateTo(Screen.NameScreen)
    }

}