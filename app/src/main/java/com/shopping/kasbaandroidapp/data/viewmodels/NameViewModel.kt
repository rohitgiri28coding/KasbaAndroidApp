package com.shopping.kasbaandroidapp.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shopping.kasbaandroidapp.auth.AuthRepository
import com.shopping.kasbaandroidapp.auth.AuthResult
import com.shopping.kasbaandroidapp.data.signup.NameUiEvent
import com.shopping.kasbaandroidapp.data.signup.NameUiState
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    var message = mutableStateOf("")
    private val nameUiState = mutableStateOf( NameUiState())
    fun onEvent(event: NameUiEvent){
        when(event){
            is NameUiEvent.NameChange -> {
                nameUiState.value = nameUiState.value.copy(
                    name = event.name
                )
            }
            NameUiEvent.ValidateLoginButtonClicked -> {
                login()
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            val res = repository.signUp(phoneNumber = "97404392382", name = nameUiState.value.name)
            when(res){
                is AuthResult.Authorized -> Router.navigateTo(Screen.OTPScreen)
                is AuthResult.Unauthorized -> message.value = "Unauthorized"
                is AuthResult.UnknownError -> message.value = "Unknown Error"
            }
        }
    }
}