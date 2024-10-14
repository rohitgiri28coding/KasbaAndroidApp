package com.shopping.kasbaandroidapp.data.forgotpassword

sealed class ForgotPasswordUiEvent {
    data class EmailChange(val email: String): ForgotPasswordUiEvent()
    data object ValidateResetButtonClicked: ForgotPasswordUiEvent()
}