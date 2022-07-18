package com.shobu95.crebitscompose.ui.screens.transactions.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shobu95.crebitscompose.ui.screens.transactions.list.TransactionViewModel
import com.shobu95.crebitscompose.ui.screens.transactions.list.state.TransactionListState
import kotlinx.coroutines.CoroutineScope

@Composable
fun TransactionsBody(
    modifier: Modifier,
    state: TransactionListState,
    viewModel: TransactionViewModel,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
) {
    Column(
        modifier = modifier
    ) {
        TransactionList(
            state = state,
            viewModel = viewModel,
            scope = scope,
            scaffoldState = scaffoldState
        )
    }
}