package com.example.memorymap.controller.api.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.memorymap.views.DashboardScreen
import com.example.memorymap.views.ForgotPasswordScreen
import com.example.memorymap.views.LoginScreen
import com.example.memorymap.views.RegistrationScreen
import com.example.memorymap.views.SplashScreen

@Composable
fun AuthNavigation() {
    val navController = rememberNavController()
    //val startScreen = if (isLoggedIn()) "dashboard" else "splash"
    var showedSplash by remember { mutableStateOf(false) }

    val start = if (! showedSplash) "splash" else "login"

    showedSplash = true

    NavHost(
            navController = navController ,
            startDestination = start
    ) {
        composable("splash") {
            SplashScreen(onNavigateToLogin = { navController.navigate("login") })
        }

        composable("login") {
            LoginScreen(onNavigateToRegister = { navController.navigate("register") } ,
                        onNavigateToDashboard = { navController.navigate("dashboard") } ,
                        onNavigateToForgotPassword = { navController.navigate("forgotPassword") })
        }
        composable("register") {
            RegistrationScreen(
                    onNavigateToLogin = { navController.popBackStack() } ,
                    onNavigateToDashboard = { navController.navigate("dashboard") }
            )
        }
        composable("dashboard") {
            DashboardScreen(onNavigateToLogin = { navController.popBackStack() })
        }
        composable("forgotPassword") {
            ForgotPasswordScreen(onNavigateToLogin = { navController.popBackStack() })
        }

    }
}

fun isLoggedIn() : Boolean {
    TODO()
}
