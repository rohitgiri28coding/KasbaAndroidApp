package com.shopping.kasbaandroidapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen

@Composable
fun WelcomeScreen() {
    Column (
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text("Welcome To Kasba!", fontSize = 24.sp)
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            onClick = {
                Router.navigateTo(Screen.LoginScreen)
            },
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text("Login")
        }
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            onClick = {
                Router.navigateTo(Screen.SignUpScreen)
            },
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text("Sign Up")
        }
        Spacer(modifier = Modifier.size(60.dp))
    }
}