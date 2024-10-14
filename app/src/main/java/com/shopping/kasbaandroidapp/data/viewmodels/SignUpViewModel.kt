package com.shopping.kasbaandroidapp.data.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.shopping.kasbaandroidapp.data.rules.Validator
import com.shopping.kasbaandroidapp.data.signup.RegistrationUiState
import com.shopping.kasbaandroidapp.data.signup.SignUpUiEvent

class SignUpViewModel: ViewModel() {

    private val TAG = SignUpViewModel::class.simpleName

    private var registrationUiState = mutableStateOf(RegistrationUiState())

    var allValidationPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)
    fun onEvent(event: SignUpUiEvent){
        when(event){
            is SignUpUiEvent.EmailChange -> {
                registrationUiState.value = registrationUiState.value.copy(
                    email = event.email
                )
                printState()
            }
            is SignUpUiEvent.PasswordChange -> {
                registrationUiState.value = registrationUiState.value.copy(
                    password = event.password
                )
                printState()
            }
//            is SignUpUiEvent.RegisterButtonClicked -> {
//                signcUp()
//            }
        }
        validateDataWithRules()
    }
    fun getEmail(): String {
        return registrationUiState.value.email
    }
    fun getPassword(): String {
        return registrationUiState.value.password
    }
    private fun validateDataWithRules() {
        val emailResult = Validator.validateEmail(
            registrationUiState.value.email
        )
        val passwordResult = Validator.validatePassword(
            registrationUiState.value.password
        )

        Log.d(TAG, "inside validate with rules")
        Log.d(TAG, "email: $emailResult")
        Log.d(TAG, "password: $passwordResult")

        registrationUiState.value = registrationUiState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status,
        )
        allValidationPassed.value = emailResult.status && passwordResult.status
        Log.d("validation", "${allValidationPassed.value}")
    }

    private fun printState(){
        Log.d(TAG, "Inside printState")
        Log.d(TAG, registrationUiState.value.toString())
    }
//    fun signUp(
//        auth: FirebaseAuth,
//        onSignedIn: (FirebaseUser) -> Unit
//    ) {
//        val email: String=registrationUiState.value.email
//        val password: String = registrationUiState.value.password
//        val firstName ="Random"
//        val lastName =" One"
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val user = auth.currentUser
//
//                    // Create a user profile in Firestore
//                    val userProfile = hashMapOf(
//                        "firstName" to firstName,
//                        "lastName" to lastName,
//                        "email" to email
//                    )
//
//                    val firestore = FirebaseFirestore.getInstance()
//                    firestore.collection("users")
//                        .document(user!!.uid)
//                        .set(userProfile)
//                        .addOnSuccessListener {
//                            onSignedIn(user)
//                        }
//                        .addOnFailureListener {
//                            Log.e("SignUp", "Error adding user profile: $it")
//
//                        }
//                } else {
//                    // Handle sign-up failure
//                    Log.e("SignUp", "Error adding user profile: else")
//
//                }
//            }
//    }
//
//   private fun signcUp() {
//        Log.d(TAG, "Inside signup")
//        printState()
//
//        createUserInFirebase(
//            email = registrationUiState.value.email,
//            password = registrationUiState.value.password
//        )
//    }



//    private fun createUserInFirebase(email: String, password: String){
//        signUpInProgress.value = true
//        FirebaseAuth
//            .getInstance()
//            .createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener {
//                Log.d(TAG, "Inside on complete listener")
//                Log.d(TAG, "isSuccessful = ${it.isSuccessful}")
//                signUpInProgress.value = false
//                if (it.isSuccessful) {
//                    Router.navigateTo(Screen.HomeScreen)
//                }
//            }
//            .addOnFailureListener{
//                signUpInProgress.value = false
//                Log.d(TAG, "Inside on failure listener")
//                Log.d(TAG, "Exception -> ${it.message}")
//                Log.d(TAG, "Exception -> ${it.printStackTrace()}")
//            }
//    }
}