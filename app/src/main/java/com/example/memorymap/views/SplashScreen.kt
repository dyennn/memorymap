package com.example.memorymap.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.memorymap.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigateToLogin : () -> Unit)
{
    var startAnimation by remember { mutableStateOf(false) }

    val alphaAnim = animateFloatAsState(
            targetValue = if (startAnimation) 1f else 0f,
            animationSpec = tween(durationMillis = 1000),
            label = "Splash Animation"
    )

    LaunchedEffect(Unit) {
        startAnimation = true
        delay(2000) // 2-second splash delay
        onNavigateToLogin()
    }

    Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface
    ) {
        Column(
                modifier = Modifier
                        .fillMaxSize()
                        .alpha(alphaAnim.value),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                    painter = painterResource(id = R.drawable.oval_logo), // Replace with your logo
                    contentDescription = "Splash Logo",
                    modifier = Modifier.size(150.dp)
            )
        }
    }
}

