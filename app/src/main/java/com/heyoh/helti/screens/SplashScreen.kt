package com.heyoh.helti.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.heyoh.helti.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    goToLogin: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        goToLogin()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_1),
            contentDescription = "Logo NutriPlay",
            modifier = Modifier.size(150.dp, 150.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(navController: NavController = rememberNavController()) {
    SplashScreen(::goToLoginPreview)
}

private fun goToLoginPreview() {}