package com.shopping.kasbaandroidapp.data.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shopping.kasbaandroidapp.data.OTPUiEvent
import com.shopping.kasbaandroidapp.data.signup.NameUiEvent
import com.shopping.kasbaandroidapp.data.OTPUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OTPViewModel @Inject constructor(): ViewModel(){
    private val otpUiState = mutableStateOf( OTPUiState())
    fun onEvent(event: OTPUiEvent){
        when(event){
            is OTPUiEvent.OTPChange -> {
                otpUiState.value = otpUiState.value.copy(
                    otp = event.otp
                )
            }
            OTPUiEvent.ValidateLoginButtonClicked -> TODO()
        }
    }
}