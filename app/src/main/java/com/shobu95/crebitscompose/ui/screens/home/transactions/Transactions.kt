package com.shobu95.crebitscompose.ui.screens.home.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TransactionsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Transactions")
    }
}

@Preview
@Composable
fun TransactionsPreview() {
    TransactionsScreen()
}