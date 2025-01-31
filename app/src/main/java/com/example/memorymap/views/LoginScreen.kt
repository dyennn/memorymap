package com.example.memorymap.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.memorymap.ui.components.ButtonComponent
import com.example.memorymap.ui.components.TextButtonComponent
import com.example.memorymap.ui.components.Heading1
import com.example.memorymap.ui.components.PasswordFieldComponent
import com.example.memorymap.ui.components.PositionedImage
import com.example.memorymap.ui.components.TextFieldComponent
import com.example.memorymap.viewmodel.AuthViewModel
import com.example.memorymap.viewmodel.Resource

@Composable
fun LoginScreen(
        onNavigateToRegister : () -> Unit ,
        onNavigateToDashboard : () -> Unit ,
        onNavigateToForgotPassword : () -> Unit ,
        )
{
    val viewModel : AuthViewModel = viewModel()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by viewModel.loginState
    val focusManager = LocalFocusManager.current
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 43.dp, top = 32.dp, end = 43.dp, bottom = 32.dp)
                    .clickable{
                        focusManager.clearFocus()
                    },
            verticalArrangement = Arrangement.Top,

    ) {

        PositionedImage()
        Heading1(text = "Login")
        Spacer(modifier = Modifier.height(12.dp))
        TextFieldComponent(
                value = email ,
                onValueChange = { email = it } ,
                label = "Email Address" ,
                placeholder = "Enter your email" ,
                isError = loginState is Resource.Error
        )
        PasswordFieldComponent(
                value = password ,
                onValueChange = { password = it } ,
                label = "Password" ,
                placeholder = "Enter your password" ,
                isError = loginState is Resource.Error ,
                errorMessage = (loginState as? Resource.Error)?.message ?: ""
        )
        TextButtonComponent(onClick = onNavigateToForgotPassword, text = "Forgot Password?")
        Spacer(modifier = Modifier.height(24.dp))

        ButtonComponent(
                onClick = { viewModel.login(email , password) } ,
                modifier = Modifier.fillMaxWidth() ,
                enabled = loginState !is Resource.Loading ,
                text = "Log In"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
                modifier = Modifier.fillMaxWidth() ,
                horizontalArrangement = Arrangement.Center
        ) {
            TextButtonComponent(onClick = onNavigateToRegister , text = "Don't have an account? Sign Up")
        }

        when (loginState)
        {
            is Resource.Loading -> CircularProgressIndicator()
            is Resource.Success ->
            {
                LaunchedEffect(Unit) {
                    onNavigateToDashboard()
                }
            }

            else                ->
            {
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview()
{
    LoginScreen(
            onNavigateToRegister = {} ,
            onNavigateToDashboard = {} ,
            onNavigateToForgotPassword = {}
    )
}