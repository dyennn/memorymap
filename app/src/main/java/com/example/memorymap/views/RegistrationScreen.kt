package com.example.memorymap.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.memorymap.ui.components.ButtonComponent
import com.example.memorymap.ui.components.Heading1
import com.example.memorymap.ui.components.PasswordFieldComponent
import com.example.memorymap.ui.components.PositionedImage
import com.example.memorymap.ui.components.TextFieldComponent
import com.example.memorymap.viewmodel.AuthViewModel
import com.example.memorymap.viewmodel.Resource

@Composable
fun RegistrationScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToDashboard: () -> Unit
) {
    val viewModel: AuthViewModel = viewModel()

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val registerState by viewModel.registerState

    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 43.dp, top = 32.dp, end = 43.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.Top

    ) {
        PositionedImage()
        Heading1("Register")
        TextFieldComponent(value = name, onValueChange = { name = it }, label = "Full Name", placeholder = "Enter your full name", isError = registerState is Resource.Error)
        TextFieldComponent(value = email, onValueChange = { email = it }, label = "Email Address", placeholder = "Enter your email", isError = registerState is Resource.Error)
        PasswordFieldComponent(value = password, onValueChange = { password = it }, label = "Password", placeholder = "Enter your password", isError =  registerState is Resource.Error)
        PasswordFieldComponent(value = confirmPassword, onValueChange = { confirmPassword = it }, label = "Confirm Password", placeholder = "Re-enter your password", isError = registerState is Resource.Error)
        Spacer(modifier = Modifier.height(24.dp))
        ButtonComponent(text = "Create Account", onClick = { viewModel.register(name, email, password, confirmPassword) }, modifier = Modifier.fillMaxWidth(), enabled = registerState !is Resource.Loading)
        Spacer(modifier = Modifier.height(24.dp))
        TextButton(
            onClick = onNavigateToLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back to Login")
        }

        when (registerState) {
            is Resource.Loading -> CircularProgressIndicator()
            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    onNavigateToDashboard()
                }
            }
            else -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen({}, {})
}