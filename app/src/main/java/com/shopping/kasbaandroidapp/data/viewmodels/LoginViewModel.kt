package com.shopping.kasbaandroidapp.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shopping.kasbaandroidapp.auth.AuthRepository
import com.shopping.kasbaandroidapp.data.login.LoginUiEvent
import com.shopping.kasbaandroidapp.data.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: AuthRepository): ViewModel(){

    private var loginUiState  = mutableStateOf(LoginUiState())

    fun onEvent(event: LoginUiEvent){
        when(event){
            is LoginUiEvent.EmailOrNumberChange -> {
                loginUiState.value = loginUiState.value.copy(
                    emailOrNumber = event.emailOrNumber
                )
            }

            LoginUiEvent.ValidateLoginButtonClicked -> {
                login()
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            repository.authenticate()
        }
    }
}