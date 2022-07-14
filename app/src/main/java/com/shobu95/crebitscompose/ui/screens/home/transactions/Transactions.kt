package com.shobu95.crebitscompose.ui.screens.home.transactions

import androidx.annotation.StringRes
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar
import com.shobu95.crebitscompose.ui.theme.ThemeBackground
import com.shobu95.crebitscompose.ui.theme.ThemeBlack
import com.shobu95.crebitscompose.ui.theme.ThemeWhite


@Preview
@Composable
fun TransactionsPreview() {
    TransactionsScreen(HomeScreenItem.Transactions.title, {})
}


@Composable
fun TransactionsScreen(@StringRes title: Int, onAddClick: () -> Unit) {
    Scaffold(
        backgroundColor = ThemeBackground,
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                false
            ) {}
        },
        floatingActionButton = { AddTransactionFab(onAddClick) },
        floatingActionButtonPosition = FabPosition.End
    ) {

    }
}

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

