package com.shopping.kasbaandroidapp.data.signup

sealed class SignUpUiEvent {
    data class EmailChange(val email: String): SignUpUiEvent()
    data class PasswordChange(val password: String): SignUpUiEvent()
//    data object RegisterButtonClicked: SignUpUiEvent()
}