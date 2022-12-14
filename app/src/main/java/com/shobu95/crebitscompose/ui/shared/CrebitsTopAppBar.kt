package com.shobu95.crebitscompose.ui.shared

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun CrebitsTopAppBar(title: String, showBackButton: Boolean, onBackClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.secondary,
        navigationIcon = if (showBackButton) {
            {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = MaterialTheme.colors.secondary,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            null
        }
    )

}