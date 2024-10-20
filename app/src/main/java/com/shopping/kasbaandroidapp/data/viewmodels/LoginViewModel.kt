package com.shopping.kasbaandroidapp.data.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shopping.kasbaandroidapp.auth.AuthRepository
import com.shopping.kasbaandroidapp.auth.AuthResult
import com.shopping.kasbaandroidapp.data.login.LoginUiEvent
import com.shopping.kasbaandroidapp.data.login.LoginUiState
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
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
            val res = repository.signIn(loginUiState.value.emailOrNumber)
            when(res){
                is AuthResult.Authorized -> Router.navigateTo(Screen.OTPScreen)
                is AuthResult.Unauthorized -> Log.d("error","unauthorized")
                is AuthResult.UnknownError -> Log.d("error1", "unknown error")
            }
        }
    }
}