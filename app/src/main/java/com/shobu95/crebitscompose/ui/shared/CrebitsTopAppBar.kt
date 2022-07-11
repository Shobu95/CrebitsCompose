package com.shobu95.crebitscompose.ui.shared

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CrebitsTopAppBar(title: String, showBackButton: Boolean, onBackClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        navigationIcon = if (showBackButton) {
            {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            null
        }
    )

}