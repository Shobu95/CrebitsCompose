package com.shobu95.crebitscompose.ui.screens.transactions.list.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AddTransactionFab(onAddClick: () -> Unit) {
    FloatingActionButton(
        onClick = onAddClick,
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        Icon(
            Icons.Filled.Add,
            tint = Color.White,
            contentDescription = "Add Transaction"
        )
    }
}