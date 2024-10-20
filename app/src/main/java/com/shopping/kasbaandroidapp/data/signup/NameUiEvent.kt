package com.shopping.kasbaandroidapp.data.signup

sealed class NameUiEvent {
    data class NameChange(val name: String): NameUiEvent()
    data object ValidateLoginButtonClicked: NameUiEvent()
}