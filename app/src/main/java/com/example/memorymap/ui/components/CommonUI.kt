package com.example.memorymap.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memorymap.R

//LOGO
@Composable
fun PositionedImage() {
    Box (Modifier
        .padding(27.dp)
        .fillMaxWidth()){
        Image(
            painter = painterResource(id = R.drawable.oval_logo),
            contentDescription = "Centered Image",
            modifier = Modifier
                .size(172.59.dp)
                .padding(bottom = 27.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun Heading1(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp),
        style = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Bold,
            letterSpacing = MaterialTheme.typography.headlineLarge.fontSize * 0.02f
        ),
        textAlign = TextAlign.Center
    )
}


//BODY
@Composable
fun NormalTextComponent(text: String, textAlign: TextAlign = TextAlign.Center) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(
            fontSize = 20.sp
        ),
        textAlign = textAlign,
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 35.dp)
    )
}

//HEADING
@Composable
fun HeadingTextComponent(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontSize = 22.sp
        ),
        modifier = Modifier
            .padding(start = 5.dp)
    )
}

//TEXT FIELD
@Composable
fun TextFieldComponent(label: String) {
    var text by remember { mutableStateOf("") }
    HeadingTextComponent(label)
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 7.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(4.dp),
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.25f),
                spotColor = Color.Black.copy(alpha = 0.25f)
            ),
        placeholder = {
            Text(
                text = "Enter $label...",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxWidth()
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}

// PASSWORD TEXT FIELD
@Composable
fun PasswordFieldComponent(label: String) {
    var text by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    HeadingTextComponent(label)
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 7.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(4.dp),
                clip = true,
                ambientColor = Color.Black.copy(alpha = 0.25f),
                spotColor = Color.Black.copy(alpha = 0.25f)
            ),
        placeholder = {
            Text(
                text = if (label == "Confirm Password") "Repeat Password..."
                else "Enter $label...",
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxWidth()
            )
        },
        trailingIcon = {
            val icon = if (passwordVisible) {
                Icons.Outlined.Visibility
            } else {
                Icons.Outlined.VisibilityOff
            }
            val description = if (passwordVisible) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = icon,
                    contentDescription = description
                )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}

// REGISTER BUTTON
@Composable
fun ButtonComponent(
    value: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = enabled,
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = (22 * 0.02).sp // 2% of font size
            )
        )
    }
}

@Composable
fun CustomButtonComponent(
    containerColor: Color,
    text: String
) {
    Button(
        onClick = { /* Handle click */ },
        modifier = Modifier
            .width(294.85.dp)
            .height(104.07.dp)
            .padding(bottom = 21.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.White
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 2.dp
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(
                fontSize = 20.sp
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun LoginPrompt(onLoginClick: () -> Unit) {
    val loginColor = Color(0xFF553BFF)
    val annotatedString = buildAnnotatedString {
        append("Already have an account? ")
        pushStringAnnotation(tag = "login", annotation = "login")
        withStyle(
            style = SpanStyle(
                color = loginColor,
                fontWeight = FontWeight.Medium
            )
        ) {
            append("Login")
        }
        pop()
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 97.dp),
        contentAlignment = Alignment.Center
    ) {
        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(
                    start = offset,
                    end = offset
                ).firstOrNull()?.let {
                    if (it.tag == "login") {
                        onLoginClick()
                    }
                }
            },
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier.wrapContentWidth()
        )
    }
}

@Composable
fun TermsAndPrivacyCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTermsClicked: () -> Unit,
    onPrivacyClicked: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier
        )

        val annotatedString = buildAnnotatedString {
            append("By creating an account, you agree to our ")

            // Terms of Service annotation
            pushStringAnnotation(tag = "terms", annotation = "terms")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append("Terms")
            }
            pop()

            append(" and acknowledge our ")

            // Privacy Policy annotation
            pushStringAnnotation(tag = "privacy", annotation = "privacy")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append("Privacy Policy")
            }
            pop()
        }

        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset)
                    .firstOrNull()
                    ?.let { annotation ->
                        when (annotation.tag) {
                            "terms" -> onTermsClicked()
                            "privacy" -> onPrivacyClicked()
                        }
                    }
            },
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ForgotPasswordButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "Forgot your password?",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable { onClick() }
        )
    }
}

// PREVIEWS

@Preview(showBackground = true)
@Composable
fun NormalTextPreview(){
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
