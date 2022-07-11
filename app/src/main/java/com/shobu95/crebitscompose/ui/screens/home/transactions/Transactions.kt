package com.shobu95.crebitscompose.ui.screens.home.transactions

import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar

@Composable
fun TransactionsScreen(@StringRes title: Int) {
    Scaffold(
        topBar = { CrebitsTopAppBar(title = stringResource(id = title)) }
    ) {

    }
}

@Preview
@Composable
fun TransactionsPreview() {
    TransactionsScreen(HomeScreenItem.Transactions.title)
}