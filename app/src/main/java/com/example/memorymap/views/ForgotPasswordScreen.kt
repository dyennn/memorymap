package com.example.memorymap.views

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPasswordScreen(onNavigateToLogin : () -> Unit)
{
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var resetCode by remember { mutableStateOf(TextFieldValue("")) }

    Column{
        IconButton(onClick = { onNavigateToLogin() }, modifier = Modifier.align(Alignment.Start).padding(top = 16.dp)) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack , contentDescription = "Back")
        }
    }
    Column(
            modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp) ,
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally
          ) {


        Spacer(modifier = Modifier.height(20.dp))

        Text(
                text = "Forgot Password?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
                text = "Please enter your registered email address. We will get back to you with the reset password link and confirmation OTP." ,
                fontSize = 14.sp ,
                color = Color.Gray ,
                textAlign = TextAlign.Center ,
                modifier = Modifier.fillMaxWidth()
            )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
                         )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
                onClick = { /* Handle send code */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0))
              ) {
            Text("Send Code", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
                value = resetCode,
                onValueChange = { resetCode = it },
                label = { Text("Reset Code") },
                modifier = Modifier.fillMaxWidth()
                         )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
                onClick = { /* Handle verify code */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors( containerColor = Color(0xFF9C27B0))
              ) {
            Text("Verify Code", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen {  }

}