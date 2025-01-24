package com.example.memorymap.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.memorymap.ui.components.CustomButtonComponent
import com.example.memorymap.ui.components.Heading1
import com.example.memorymap.ui.components.LoginPrompt
import com.example.memorymap.ui.components.NormalTextComponent
import com.example.memorymap.ui.components.PositionedImage

@Composable
fun CreateAccountScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(43.dp)
    ) {
        Column {
            PositionedImage()
            Heading1("Create Account")
            NormalTextComponent(text = "Are you a patient or a caregiver?", textAlign = TextAlign.Center )
            CustomButtonComponent(text = "Patient", containerColor = Color(0xFF824C76))
            CustomButtonComponent(text = "Caregiver", containerColor = Color(0xFF009708))
            LoginPrompt( onLoginClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountScreenPreview() {
    CreateAccountScreen()
}