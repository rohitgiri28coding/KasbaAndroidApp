package com.shopping.kasbaandroidapp.data.rules

import android.util.Patterns

object Validator {

    fun validateName(name: String): ValidationResult {
        return ValidationResult(
            name.isNotEmpty() && name.length>=2 && name.matches("^\\s*\\w+\\s*$".toRegex())
        )
    }
    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        )
    }
    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            password.isNotEmpty() && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)[^\\\\s]{8,}\$".toRegex())
        )
    }
    fun validateCheckButton(checkButtonState: Boolean): ValidationResult {
        return ValidationResult(
            checkButtonState
        )
    }
}
data class ValidationResult(
    val status: Boolean = false
)