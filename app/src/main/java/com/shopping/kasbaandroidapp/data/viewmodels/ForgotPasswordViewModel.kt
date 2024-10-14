package com.shopping.kasbaandroidapp.data.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shopping.kasbaandroidapp.data.forgotpassword.ForgotPasswordUiEvent
import com.shopping.kasbaandroidapp.data.forgotpassword.ForgotPasswordUiState
import com.shopping.kasbaandroidapp.data.rules.Validator
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen

class ForgotPasswordViewModel: ViewModel() {
    private var TAG = ForgotPasswordViewModel::class.simpleName
    private var forgotPasswordUiState = mutableStateOf(ForgotPasswordUiState())
    var allValidationPassed = mutableStateOf(false)
    fun onEvent(event: ForgotPasswordUiEvent) {
        validateDataWithRules()
        when (event) {
            is ForgotPasswordUiEvent.EmailChange -> {
                forgotPasswordUiState.value = forgotPasswordUiState.value.copy(
                    email = event.email
                )
                printState()
            }
            ForgotPasswordUiEvent.ValidateResetButtonClicked -> {
                resetPassword()
            }
        }
    }

    private fun resetPassword() {
        printState()
        resetPasswordUsingFireBase(email = forgotPasswordUiState.value.email)
    }

    private fun resetPasswordUsingFireBase(email: String)   {
        Router.navigateTo(Screen.LoginScreen)
    }


    private fun printState(){
        Log.d(TAG, "Inside printState")
        Log.d(TAG, forgotPasswordUiState.value.toString())
    }
    private fun validateDataWithRules() {
        val emailResult = Validator.validateEmail(
            forgotPasswordUiState.value.email
        )
        Log.d(TAG, "inside validate with rules")
        Log.d(TAG, "email: $emailResult")
        forgotPasswordUiState.value = forgotPasswordUiState.value.copy(
            emailError = emailResult.status
        )
        allValidationPassed.value = emailResult.status
    }
}