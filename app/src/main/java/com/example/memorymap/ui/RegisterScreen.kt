package com.example.memorymap.ui

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
import androidx.compose.ui.unit.dp
import com.example.memorymap.R
import com.example.memorymap.ui.components.ButtonComponent
import com.example.memorymap.ui.components.Heading1
import com.example.memorymap.ui.components.PasswordFieldComponent
import com.example.memorymap.ui.components.PositionedImage
import com.example.memorymap.ui.components.TextFieldComponent

@Composable
fun RegisterScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(43.dp)
    ) {
        Column {
            PositionedImage()
            Heading1(text = "Create Account")
            TextFieldComponent(label = "Email")
            PasswordFieldComponent(label = "Password")
            PasswordFieldComponent(label = "Confirm Password")
            Spacer(modifier = Modifier.height(55.dp))
            ButtonComponent(onClick = {}, value = stringResource(id = R.string.register))
        }
    }
}