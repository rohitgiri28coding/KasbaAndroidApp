package com.shopping.kasbaandroidapp.data.login

sealed class LoginUiEvent {
    data class EmailOrNumberChange(val emailOrNumber: String): LoginUiEvent()
    data object ValidateLoginButtonClicked: LoginUiEvent()
}