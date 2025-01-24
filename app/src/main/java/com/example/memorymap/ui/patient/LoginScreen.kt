package com.example.memorymap.ui.patient

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memorymap.R
import com.example.memorymap.ui.components.ButtonComponent
import com.example.memorymap.ui.components.ForgotPasswordButton
import com.example.memorymap.ui.components.Heading1
import com.example.memorymap.ui.components.PasswordFieldComponent
import com.example.memorymap.ui.components.PositionedImage
import com.example.memorymap.ui.components.TextFieldComponent

@Composable
fun LoginScreen() {
    Surface(

        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(43.dp)
    ) {
        Column {
            PositionedImage()
            Heading1(text = "Login")
            TextFieldComponent(label = "Email")
            PasswordFieldComponent(label = "Password")
            PasswordFieldComponent(label = "Confirm Password")
            Spacer(modifier = Modifier.height(55.dp))
            ButtonComponent(onClick = {}, value = stringResource(id = R.string.login))
            ForgotPasswordButton {  }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}