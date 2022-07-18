package com.shobu95.crebitscompose.ui.screens.transactions.list.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.shobu95.crebitscompose.ui.theme.ThemeBlack
import com.shobu95.crebitscompose.ui.theme.ThemeWhite

@Composable
fun AddTransactionFab(onAddClick: () -> Unit) {
    FloatingActionButton(
        onClick = onAddClick,
        backgroundColor = ThemeBlack,
        contentColor = ThemeWhite
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add Transaction")
    }
}