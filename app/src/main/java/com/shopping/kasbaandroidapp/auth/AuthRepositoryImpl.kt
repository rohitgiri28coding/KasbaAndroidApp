package com.shopping.kasbaandroidapp.auth

import android.content.SharedPreferences
import android.util.Log
import retrofit2.HttpException

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val prefs: SharedPreferences
): AuthRepository{
    override suspend fun signUp(phoneNumber: String, name: String): AuthResult<Unit> {
        return try {
            api.signUp(
                request = AuthRequest(
                    phoneNumber = phoneNumber,
                    name = name
                )
            )
            signIn(phoneNumber)
        }catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            }else{
                Log.e("Error1","${e.printStackTrace()}")
                AuthResult.UnknownError()
            }
        }catch (e: Exception){
            Log.e("Error","$e.message")
            AuthResult.UnknownError()

        }
    }

    override suspend fun signIn(phoneNumber: String): AuthResult<Unit> {
        return try {
            val response = api.signIn(
                request = AuthRequest1(
                    phoneNumber = phoneNumber,
                )
            )
            prefs.edit()
                .putString("jwt", response.token)
                .apply()
            AuthResult.Authorized()
        }catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            }else{
                AuthResult.UnknownError()
            }
        }catch (e: Exception){
            AuthResult.UnknownError()
        }    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return try {
            val token = prefs.getString("jwt", null)?: return AuthResult.Unauthorized()
            api.authenticate("bearer $token")
            AuthResult.Authorized()
        }catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            }else{
                AuthResult.UnknownError()
            }
        }catch (e: Exception){
            AuthResult.UnknownError()
        }
    }
}