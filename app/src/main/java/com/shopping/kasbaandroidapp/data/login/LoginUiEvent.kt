package com.shopping.kasbaandroidapp.data.login

sealed class LoginUiEvent {
    data class EmailChange(val email: String): LoginUiEvent()
    data class PasswordChange(val password: String): LoginUiEvent()
//    data object ValidateLoginButtonClicked: LoginUiEvent()
}