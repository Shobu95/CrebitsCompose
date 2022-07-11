package com.shobu95.crebitscompose.ui.shared

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CrebitsTopAppBar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )

}