package com.shobu95.crebitscompose.ui.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.shobu95.crebitscompose.R
import com.shobu95.crebitscompose.ui.theme.CrebitsComposeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrebitsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    SplashScreen()
                    navigateToHome(LocalContext.current)
                }
            }
        }
    }

    fun navigateToHome(context: Context) {
        lifecycleScope.launch {
            delay(3000)
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            context.startActivity(intent)
            finish()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    CrebitsComposeTheme {
        SplashScreen()
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val splashIcon = painterResource(id = R.drawable.ic_android_blue)
            Image(
                painter = splashIcon,
                contentDescription = "splash icon",
                Modifier.size(40.dp)
            )
            Text(
                text = "CreBits",
                color = Color.Black,
                fontSize = 28.sp
            )
        }
    }
}
