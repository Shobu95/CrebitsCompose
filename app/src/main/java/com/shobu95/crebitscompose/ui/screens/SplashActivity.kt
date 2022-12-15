package com.shobu95.crebitscompose.ui.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.shobu95.crebitscompose.R
import com.shobu95.crebitscompose.ui.screens.home.HomeActivity
import com.shobu95.crebitscompose.ui.theme.CrebitsComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    CrebitsComposeTheme {
        SplashScreen()
    }
}

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        setContent {
            CrebitsComposeTheme(viewModel.isDarkTheme) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface
                ) {
                    SplashScreen()
                    navigateToHome(LocalContext.current)
                }
            }
        }
    }

    private fun navigateToHome(context: Context) {
        lifecycleScope.launch {
            delay(1000)
            val intent = Intent(
                this@SplashActivity,
                HomeActivity::class.java
            )
            context.startActivity(intent)
            finish()
        }
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface),
        contentAlignment = Alignment.Center
    ) {
        val splashIcon = painterResource(id = R.drawable.crebits_main_icon)
        Image(
            painter = splashIcon,
            contentDescription = "splash icon",
            Modifier.size(180.dp)
        )

    }
}
