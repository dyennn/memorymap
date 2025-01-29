package com.example.memorymap.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.memorymap.R


/**
 * Composable function to display a centered image with padding.
 */
@Composable
fun PositionedImage() {
    Box(
        Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.oval_logo),
            contentDescription = "Centered Image",
            modifier = Modifier
                .size(150.59.dp)
                .padding(bottom = 27.dp)
                .align(Alignment.Center)
        )
    }
}


/**
 * Composable function to display a heading with padding.
 * @param text The text to display.
 */
@Composable
fun Heading1(text : String)
{
    Text(
            text = text ,
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp) ,
            style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold ,
                    letterSpacing = MaterialTheme.typography.headlineLarge.fontSize * 0.02f
                                                               ) ,
            textAlign = TextAlign.Center
        )
}

/**
 * Composable function to display a heading with padding.
 * @param text The text to display.
 */
@Composable
fun HeadingTextComponent(text : String)
{
    Text(
            text = text ,
            style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 20.sp
                                                               ) ,
            modifier = Modifier
                    .padding(start = 5.dp)
        )
}

/**
 * Composable function to display a heading with padding.
 * @param text The text to display.
 */
@Composable
fun NormalTextComponent(text : String , textAlign : TextAlign = TextAlign.Center)
{
    Text(
            text = text ,
            style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 20.sp
                                                           ) ,
            textAlign = textAlign ,
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp)
        )
}

/**
 * Composable function to display a label as well as a text field.
 *
 * @param value The value of the text field.
 * @param onValueChange The function to call when the value of the text field changes.
 * @param label The label to display.
 * @param placeholder The placeholder text to display.
 * @param isError Whether the text field is in an error state.
 * @param errorMessage The error message to display.
 */
@Composable
fun TextFieldComponent(
        value : String ,
        onValueChange : (String) -> Unit ,
        label : String ,
        placeholder : String ,
        isError : Boolean ,
        errorMessage : String = "" ,
                      )
{

    HeadingTextComponent(label)
    OutlinedTextField(
            value = value ,
            onValueChange = onValueChange ,
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 7.dp)
                    .shadow(
                            elevation = 4.dp ,
                            shape = RoundedCornerShape(4.dp) ,
                            clip = true ,
                            ambientColor = Color.Black.copy(alpha = 0.25f) ,
                            spotColor = Color.Black.copy(alpha = 0.25f)
                           ) ,
            placeholder = {
                Text(
                        text = "Enter $placeholder..." ,
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp) ,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f) ,
                        modifier = Modifier.fillMaxWidth()
                    )
            } ,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next) ,
            colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary ,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.outline ,
                    focusedLabelColor = MaterialTheme.colorScheme.primary ,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant ,
                    focusedContainerColor = Color.White ,
                    unfocusedContainerColor = Color.White ,
                    focusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant ,
                    unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant
                                             )
                     )
    if (isError)
    {
        Text(
                text = errorMessage ,
                color = MaterialTheme.colorScheme.error ,
                style = MaterialTheme.typography.labelSmall ,
                modifier = Modifier.padding(top = 4.dp)
            )
    }
}

/**
 * Composable function to display a password field.
 *
 * @param value The value of the text field.
 * @param onValueChange The function to call when the value of the text field changes.
 * @param label The label to display.
 * @param placeholder The placeholder text to display.
 * @param isError Whether the text field is in an error state.
 * @param errorMessage The error message to display.
 */
@Composable
fun PasswordFieldComponent(
        value : String ,
        onValueChange : (String) -> Unit ,
        label : String ,
        placeholder : String ,
        isError : Boolean ,
        errorMessage : String = "" ,
                          )
{
    var passwordVisible by remember { mutableStateOf(false) }

    HeadingTextComponent(label)
    OutlinedTextField(
            value = value ,
            onValueChange = onValueChange ,
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 7.dp)
                    .shadow(
                            elevation = 4.dp ,
                            shape = RoundedCornerShape(4.dp) ,
                            clip = true ,
                            ambientColor = Color.Black.copy(alpha = 0.25f) ,
                            spotColor = Color.Black.copy(alpha = 0.25f)
                           ) ,
            placeholder = {
                Text(
                        text = placeholder ,
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp) ,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f) ,
                        modifier = Modifier.fillMaxWidth()
                    )
            } ,
            trailingIcon = {
                val icon = if (passwordVisible)
                {
                    Icons.Outlined.Visibility
                } else
                {
                    Icons.Outlined.VisibilityOff
                }
                val description = if (passwordVisible)
                {
                    stringResource(R.string.hide_password)
                } else
                {
                    stringResource(R.string.show_password)
                }

                IconButton(onClick = { passwordVisible = ! passwordVisible }) {
                    Icon(
                            imageVector = icon ,
                            contentDescription = description
                        )
                }
            } ,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation() ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Next) ,
            colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary ,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.outline ,
                    focusedLabelColor = MaterialTheme.colorScheme.primary ,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant ,
                    focusedContainerColor = Color.White ,
                    unfocusedContainerColor = Color.White ,
                    focusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant ,
                    unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant
                                             )
                     )
    if (isError)
    {
        Text(
                text = errorMessage ,
                color = MaterialTheme.colorScheme.error ,
                style = MaterialTheme.typography.labelSmall ,
                modifier = Modifier.padding(top = 4.dp)
            )
    }
}

/**
 * Composable function to display a button.
 *
 * @param text The text to display on the button.
 * @param onClick The function to call when the button is clicked.
 * @param modifier The modifier to apply to the button.
 * @param enabled Whether the button is enabled.
 */
@Composable
fun ButtonComponent(
        text : String ,
        onClick : () -> Unit ,
        modifier : Modifier = Modifier ,
        enabled : Boolean = true ,
                   )
{
    Button(
            onClick = onClick ,
            modifier = modifier
                    .fillMaxWidth()
                    .height(48.dp) ,
            enabled = enabled ,
            elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp ,
                    pressedElevation = 8.dp
                                                              ) ,
            colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary ,
                    contentColor = MaterialTheme.colorScheme.onPrimary ,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f) ,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                                                ) ,
            shape = MaterialTheme.shapes.medium
          ) {
        Text(
                text = text ,
                style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 22.sp ,
                        fontWeight = FontWeight.Medium ,
                        letterSpacing = (22 * 0.02).sp // 2% of font size
                                                                )
            )
    }
}


/**
 * Composable function to display a checkbox.
 *
 * @param checked Whether the checkbox is checked.
 * @param onCheckedChange The function to call when the checkbox is checked or unchecked.
 * @param onTermsClicked The function to call when the terms link is clicked.
 * @param onPrivacyClicked The function to call when the privacy link is clicked.
 */
@Composable
fun TermsAndPrivacyCheckbox(
        checked : Boolean ,
        onCheckedChange : (Boolean) -> Unit ,
        onTermsClicked : () -> Unit ,
        onPrivacyClicked : () -> Unit ,
                           )
{
    Row(
            verticalAlignment = Alignment.CenterVertically ,
            modifier = Modifier.fillMaxWidth()
       ) {
        Checkbox(
                checked = checked ,
                onCheckedChange = onCheckedChange ,
                modifier = Modifier,
                colors = CheckboxDefaults.colors(
                        checkmarkColor = MaterialTheme.colorScheme.primary
                                                ),
                )

        val annotatedString = buildAnnotatedString {
            append("By creating an account, you agree to our ")

            // Terms of Service annotation
            pushStringAnnotation(tag = "terms" , annotation = "terms")
            withStyle(
                    style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary ,
                            fontWeight = FontWeight.Medium
                                     )
                     ) {
                append("Terms")
            }
            pop()

            append(" and acknowledge our ")

            // Privacy Policy annotation
            pushStringAnnotation(tag = "privacy" , annotation = "privacy")
            withStyle(
                    style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary ,
                            fontWeight = FontWeight.Medium
                                     )
                     ) {
                append("Privacy Policy")
            }
            pop()
        }

        ClickableText(
                text = annotatedString ,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(offset , offset)
                            .firstOrNull()
                            ?.let { annotation ->
                                when (annotation.tag)
                                {
                                    "terms" -> onTermsClicked()
                                    "privacy" -> onPrivacyClicked()
                                }
                            }
                } ,
                style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.onSurface
                                                               ) ,
                modifier = Modifier.weight(1f)
                     )
    }
}

@Composable
fun TextButtonComponent(onClick : () -> Unit , text : String)
{
    Box(
            modifier = Modifier
                    .padding(vertical = 8.dp)

       ) {
        Text(
                text = buildAnnotatedString {
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append(text)
            }
        },
                color = MaterialTheme.colorScheme.primary ,
                fontSize = 12.sp ,
                fontWeight = FontWeight.Medium ,
                modifier = Modifier
                        .clickable { onClick() }
            )
    }
}