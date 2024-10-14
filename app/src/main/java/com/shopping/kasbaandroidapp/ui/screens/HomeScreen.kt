package com.shopping.kasbaandroidapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shopping.kasbaandroidapp.ui.components.AppTopBar
import com.shopping.kasbaandroidapp.ui.components.NavigationDrawerBody
import com.shopping.kasbaandroidapp.ui.components.NavigationDrawerHeader
import com.shopping.kasbaandroidapp.data.viewmodels.HomeScreenViewModel
import com.shopping.kasbaandroidapp.ui.navigation.Router
import com.shopping.kasbaandroidapp.ui.navigation.Screen
import com.shopping.kasbaandroidapp.R
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
//    user: FirebaseUser, onSignOut: () -> Unit,
    homeScreenViewModel: HomeScreenViewModel = viewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
//    val firestore = FirebaseFirestore.getInstance()
    val userProfile = remember {
        mutableStateOf<User?>(null)
    }
//    LaunchedEffect(user.uid) {
//        val userDocRef = firestore.collection("users").document(user.uid).get().await()
//
//        if (!userDocRef.exists()) {
//            Log.d("UserDocRef", "User profile document exist")
//            val firstName = "New Random"
//            val lastName = " One"
//
//            firestore.collection("users")
//                .document(user.uid)
//                .set(hashMapOf(
//                    "uid" to user.uid,
//                    "firstName" to firstName,
//                    "lastName" to lastName,
//                    "email" to user.email
//                ))
//                .await()
//        }else{
//            val firstName = userDocRef.getString("firstName")
//            val lastName = userDocRef.getString("lastName")
//            userProfile.value = User(firstName, lastName, user.email ?: "")
//        }
//    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerHeader()
                HorizontalDivider()
                NavigationDrawerBody(navigationDrawerItems =
                    homeScreenViewModel.navigationItemList
                )
            }
        },
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    topBarText = stringResource(R.string.home),
                    logoutButtonClicked = {
                        Router.navigateTo(Screen.LoginScreen)
//                        onSignOut.invoke()
                    },
                    openNavigationDrawer = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                })
            },

        ) { contentPadding ->
            Surface (modifier = Modifier
                .padding(contentPadding)
                .background(Color(0xFF232421))){
                Text(text = "Home Screen")
            }
        }
    }
}
data class User(
    val firstName: String?,
    val lastName: String?,
    val email: String
)
//@Composable
//fun BackgroundImage() {
//    Image(
//        painter = painterResource(id = R.drawable.background_green),
//        contentDescription = "Background Image",
//        contentScale = ContentScale.FillBounds,
//        modifier = Modifier.fillMaxSize(1f)
//    )
//}