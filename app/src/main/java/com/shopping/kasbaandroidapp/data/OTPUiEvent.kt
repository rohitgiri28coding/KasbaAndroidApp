package com.shopping.kasbaandroidapp.data

sealed class OTPUiEvent {
    data class OTPChange(val otp: String): OTPUiEvent()
    data object ValidateLoginButtonClicked: OTPUiEvent()
}