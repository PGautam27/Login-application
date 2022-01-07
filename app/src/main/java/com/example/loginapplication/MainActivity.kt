package com.example.loginapplication

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginapplication.composable.LoginPage
import com.example.loginapplication.composable.RegistrationPage
import com.example.loginapplication.ui.theme.LoginApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            LoginApplicationTheme {

                LoginApplication()
            }
        }
    }
}

@Composable
fun LoginApplication() {
    val navController =  rememberNavController()
    NavHost(navController = navController, startDestination = "login_page", builder = {
        composable("login_page", content = { LoginPage(navController = navController)})
        composable("registration_page", content = { RegistrationPage(navController = navController)})
    } )
}
