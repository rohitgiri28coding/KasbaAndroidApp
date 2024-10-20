package com.shopping.kasbaandroidapp.data.signup

sealed class SignUpUiEvent {
    data class PhoneNumberChange(val email: String): SignUpUiEvent()
    data object RegisterButtonClicked: SignUpUiEvent()
}