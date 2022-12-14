package com.shobu95.crebitscompose.ui.screens.transactions.list.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable

@Composable
fun AddTransactionFab(onAddClick: () -> Unit) {
    FloatingActionButton(
        onClick = onAddClick,
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.primary
    ) {
        Icon(
            Icons.Filled.Add,
            tint = MaterialTheme.colors.primary,
            contentDescription = "Add Transaction"
        )
    }
}