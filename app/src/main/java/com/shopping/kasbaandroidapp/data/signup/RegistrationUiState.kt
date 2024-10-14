package com.shopping.kasbaandroidapp.data.signup

data class RegistrationUiState(
    var email: String = "",
    var password: String = "",

    var emailError: Boolean = false,
    var passwordError: Boolean = false
)