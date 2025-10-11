package com.yogesh.dicerollergame.presentation.splash_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yogesh.dicerollergame.R
import com.yogesh.dicerollergame.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    var startAnimation by remember { mutableStateOf(false) }

    val alphaAnim by animateFloatAsState(targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2000))

    val scaleAnim by animateFloatAsState(targetValue = if (startAnimation) 1f else 0.8f,
        animationSpec = tween(durationMillis = 2000))

    LaunchedEffect(key1 = true) {
        startAnimation = true

        delay(3000)

        navController.navigate(Routes.PlayerRegisterScreen) {

            popUpTo(Routes.SplashScreen) {
                inclusive = true
            }

        }


    }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(painter = painterResource(id = R.drawable.splash_screen),
            contentDescription = "Splash Screen",
            modifier = Modifier
                .fillMaxSize()
                .alpha(alphaAnim)
                .scale(scaleAnim),
            contentScale = ContentScale.Crop)

    }

}


@Preview(showSystemUi = true)
@Composable
fun Preview() {
    SplashScreen(navController = rememberNavController())
}