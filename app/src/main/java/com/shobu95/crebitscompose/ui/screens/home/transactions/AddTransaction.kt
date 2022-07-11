package com.shobu95.crebitscompose.ui.screens.home.transactions

import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shobu95.crebitscompose.ui.navigation.HomeScreenItem
import com.shobu95.crebitscompose.ui.shared.CrebitsTopAppBar

@Preview
@Composable
fun AddEditTransactionScreenPreview() {
    AddTransactionScreen(
        HomeScreenItem.AddTransaction.title,
        formState = TransactionFormState.ADD
    ) {}
}


@Composable
fun AddTransactionScreen(
    @StringRes title: Int,
    formState: TransactionFormState,
    onBackPressed: () -> Unit,
) {
    Scaffold(
        topBar = {
            CrebitsTopAppBar(
                title = stringResource(id = title),
                true,
                onBackPressed
            )
        },
    ) {

    }
}