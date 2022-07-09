package com.shobu95.crebitscompose.ui.screens.home

import HomeBottomNavBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.shobu95.crebitscompose.ui.navigation.HomeNavigationGraph
import com.shobu95.crebitscompose.ui.theme.CrebitsComposeTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrebitsComposeTheme {
               HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { HomeBottomNavBar(navController = navController) }
    ) {
        HomeNavigationGraph(navController = navController)
    }
}
