package com.shopping.kasbaandroidapp.auth

interface AuthRepository {
    suspend fun signUp(phoneNumber: String, name: String): AuthResult<Unit>
    suspend fun signIn(phoneNumber: String): AuthResult<Unit>
    suspend fun authenticate(): AuthResult<Unit>
}